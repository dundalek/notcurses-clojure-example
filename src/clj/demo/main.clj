(ns demo.main
  (:gen-class)
  (:import (com.dundalek.notcurses.swig NC notcurses_options ncplane_options NCConstants)
           (cz.adamh.utils NativeUtils)
           (java.util.concurrent.locks LockSupport)))

(set! *warn-on-reflection* true)

(def BOX_NUM 10)

(def c_red 0xd72c2f)
(def c_yel 0xffd029)
(def c_blu 0x3c497f)
(def c_whi 0xfefefe)

(def box_colors
  [c_red
   c_whi
   c_yel
   c_whi
   c_blu
   c_whi
   c_blu
   c_yel
   c_red
   c_whi])

(defmacro nc-err [form]
  `(when (< ~form 0)
     (throw (RuntimeException. ~(str "Notcurses error calling: " (name (first form)))))))

(defn ncchannel_set [channel rgb]
  (if (> channel 0xffffff)
    (throw (IllegalArgumentException.))
    (bit-or (bit-and-not channel (.intValueExact NCConstants/NC_BG_RGB_MASK))
            (.intValueExact NCConstants/NC_BGDEFAULT_MASK)
            rgb)))

(defn ncchannel_set_alpha [channel alpha]
  (if-not (zero? (bit-and-not alpha (.intValueExact NCConstants/NC_BG_ALPHA_MASK)))
    (throw (IllegalArgumentException.))
    (bit-or alpha
            (bit-and-not channel (.intValueExact NCConstants/NC_BG_ALPHA_MASK))
            (if (not= alpha (.intValueExact NCConstants/NCALPHA_OPAQUE))
              (.intValueExact NC/NC_BGDEFAULT_MASK)
              0))))

(defn ncchannels_set_fchannel [channels channel]
  (bit-or (bit-and channels 0xffffffff)
          (bit-shift-left channel 32)))

(defn ncchannels_set_bchannel [channels channel]
  (bit-or (bit-and channels (bit-shift-left 0xffffffff 32))
          channel))

(defn ncchannels_set_fg_rgb [channels rgb]
  (let [channel (-> (NC/ncchannels_fchannel channels)
                    (ncchannel_set rgb))]
    (ncchannels_set_fchannel channels channel)))

(defn ncchannels_set_bg_rgb [channels rgb]
  (let [channel (-> (NC/ncchannels_bchannel channels)
                    (ncchannel_set rgb))]
    (ncchannels_set_bchannel channels channel)))

(defn ncchannels_set_bg_alpha [channels alpha]
  (if (= alpha (.intValueExact NCConstants/NCALPHA_HIGHCONTRAST)) ; forbidden for background alpha
    (throw (IllegalArgumentException.))
    (let [channel (-> (NC/ncchannels_bchannel channels)
                      (ncchannel_set_alpha alpha))]
      (ncchannels_set_bchannel channels channel))))

(defn ncchannel_set_rgb8_clipped [channel ^long r ^long g ^long b]
  (let [r (Math/max 0 (Math/min r 255))
        g (Math/max 0 (Math/min g 255))
        b (Math/max 0 (Math/min b 255))
        c (bit-or (bit-shift-left r 16)
                  (bit-shift-left g 8)
                  b)]
    (bit-or (bit-and-not channel (.intValueExact NCConstants/NC_BG_RGB_MASK))
            (.intValueExact NCConstants/NC_BGDEFAULT_MASK)
            c)))

(defn- linear_transition [start end duration diff]
  (+ start (Math/round (double (* (- end start)
                                  (/ diff duration))))))

(defn- transition_rgb [start end duration diff]
  (let [r (linear_transition (NC/channel_r start) (NC/channel_r end) duration diff)
        g (linear_transition (NC/channel_g start) (NC/channel_g end) duration diff)
        b (linear_transition (NC/channel_b start) (NC/channel_b end) duration diff)]
    (ncchannel_set_rgb8_clipped 0 r g b)))

(defn- transition_box [start_box end_box duration diff]
  (mapv (fn [start end]
          (linear_transition start end duration diff))
        start_box
        end_box))

(defn- make_boxes_start [_dimy dimx]
  (->> (range BOX_NUM)
       (mapv (fn [_]
              (let [y -1
                    x (quot dimx 2)]
                [y x (+ y 2) (+ x 4)])))))

(defn- make_boxes_bottom_out [dimy dimx]
  (->> (range BOX_NUM)
       (mapv (fn [_]
              (let [y (+ dimy 4)
                    x (quot dimx 2)]
                [y x (+ y 2) (+ x 4)])))))

(defn- make_boxes_arranged [dimy dimx]
  (let [x0 2
        x1 (-> dimx (* 40) (quot 100))
        x2 (-> dimx (* 55) (quot 100))
        x3 (-> dimx (* 85) (quot 100))
        x4 dimx
        y0 1
        y1 (-> dimy (* 18) (quot 100))
        y2 (-> dimy (* 22) (quot 100))
        y3 (-> dimy (* 35) (quot 100))
        y4 (-> dimy (* 55) (quot 100))
        y5 (-> dimy (* 70) (quot 100))
        y6 dimy]
    [[y0 x0 y5 x1]
     [y5 x0 y6 x1]
     [y0 x1 y2 x2]
     [y2 x1 y5 x2]
     [y5 x1 y6 x2]
     [y0 x2 y3 x3]
     [y3 x2 y4 x3]
     [y4 x2 y6 x4]
     [y0 x3 y1 x4]
     [y1 x3 y4 x4]]))

(defn- make_boxes_grid [dimy dimx]
  (let [boxh (quot dimy 5)
        boxw (* boxh 2)
        y0 (-> dimy (* 20) (quot 100))
        x0 (-> dimx (* 20) (quot 100))]
    (->> (range BOX_NUM)
         (mapv (fn [i]
                (let [row (quot i 5)
                      col (mod i 5)
                      shifted (zero? (mod col 2))
                      y (+ y0
                           (* row (+ boxh (quot boxh 2)))
                           (if shifted (+ (quot boxh 2) 1) 0))
                      x (+ x0
                           (* col (+ boxw 2)))]
                   [y x (+ y boxh) (+ x boxw)]))))))

(defn- box_ylen [box]
  (- (get box 2) (get box 0) 1))

(defn- box_xlen [box]
  (- (get box 3) (get box 1) 2))

(defn make_box_planes [parent n]
  (let [opts (doto (ncplane_options.)
               (.setRows 1)
               (.setCols 1))]
    (->> (range n)
         (mapv (fn [_]
                 (NC/ncplane_create parent opts))))))

(defn- draw_boxes_colored [planes]
  (doseq [[plane color] (map list planes box_colors)]
    (let [chans (ncchannels_set_bg_rgb 0 color)]
      (nc-err (NC/ncplane_set_base plane " " 0 chans))
      (NC/ncplane_erase plane))))

(defn- draw_boxes_gradients [planes]
  (doseq [[plane color] (map list planes box_colors)]
    (let [ur (bit-or 0xffffff (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
          ul (bit-or color (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
          lr (bit-or color (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
          ll (bit-or 0x000000 (.intValueExact NCConstants/NC_BGDEFAULT_MASK))]
      (nc-err (NC/ncplane_highgradient plane ul ur ll lr (dec (NC/ncplane_dim_y plane)) (dec (NC/ncplane_dim_x plane)))))))

(defn- draw_boxes_bordered [planes]
  (doseq [plane planes]
    (NC/ncplane_erase plane)
    (nc-err (NC/ncplane_cursor_move_yx plane 0 0))
    ;; Ignoring error (e.g. the dimensions are too small), when the box fits it will be re-drawn in future frames
    (NC/ncplane_rounded_box plane 0 0 (dec (NC/ncplane_dim_y plane)) (dec (NC/ncplane_dim_x plane)) 0)))

(defn- reposition_plane [plane box]
  (nc-err (NC/ncplane_move_yx plane (get box 0) (get box 1)))
  (nc-err (NC/ncplane_resize_simple plane (box_ylen box) (box_xlen box))))

(defn- reposition_planes [planes boxes]
  (doseq [[plane box] (map list planes boxes)]
    (reposition_plane plane box)))

(defn- make_message_box [parent windowy _windowx]
  (let [l1 "Notcurses by Nick Black et al"
        l2 "Zig lang by Andrew Kelley & community"
        l3 "Liz lang & demo by Jakub Dundalek"
        l4 "Press q to quit"
        rows (+ 5 2)
        opts (doto (ncplane_options.)
               (.setRows rows)
               (.setCols (-> (count l2) (+ 4)))
               (.setX 4)
               (.setY (- windowy rows 2)))
        plane (NC/ncplane_create parent opts)
        chans (-> 0
                  (ncchannels_set_bg_rgb 0x000000)
                  (ncchannels_set_bg_alpha (.intValueExact NCConstants/NCALPHA_BLEND)))
        _ (nc-err (NC/ncplane_set_base plane " " 0 chans))
        border_chans (ncchannels_set_fg_rgb 0 c_red)]

    (NC/ncplane_rounded_box plane 0 border_chans (dec (NC/ncplane_dim_y plane)) (dec (NC/ncplane_dim_x plane)) 0)
    (nc-err (NC/ncplane_putstr_yx plane 1 2 l1))
    (nc-err (NC/ncplane_putstr_yx plane 2 2 l2))
    (nc-err (NC/ncplane_putstr_yx plane 3 2 l3))
    (nc-err (NC/ncplane_putstr_yx plane 5 2 l4))

    plane))

(def NANOSECS_IN_SEC 1000000000)
(def step_ns (/ NANOSECS_IN_SEC 60))

(defn sleep_until_ns [ns]
  (let [sleep_ns (- ns (System/nanoTime))]
    (when (pos? sleep_ns)
      (LockSupport/parkNanos sleep_ns))))

(defn- run_transition [ncs duration ctx render]
  (let [time_start (System/nanoTime)]
    (loop []
      (let [t (System/nanoTime)]
       (when (< t (+ time_start duration))
        (render ctx (- t time_start) duration)
        (nc-err (NC/notcurses_render ncs))
        (sleep_until_ns (+ t step_ns))
        (recur))))
    (render ctx duration duration)
    (nc-err (NC/notcurses_render ncs))))

(defn- run_serial_transition [ncs duration render]
  (dotimes [i BOX_NUM]
    (run_transition ncs duration i render)))

(defn -main []
  (NativeUtils/loadLibraryFromJar (str "/" (System/mapLibraryName "notcurses-jni")))

  (let [opts (doto (notcurses_options.)
               #_(.setFlags (.longValueExact NCConstants/NCOPTION_SUPPRESS_BANNERS))
               #_(.setLoglevel ncloglevel_e/NCLOGLEVEL_ERROR))
        ncs (NC/notcurses_core_init opts nil)
        plane (NC/notcurses_stdplane ncs)
        dimx (Math/max (NC/ncplane_dim_x plane) (int 80))
        dimy (Math/max (NC/ncplane_dim_y plane) (int 25))
        box_planes (make_box_planes plane BOX_NUM)
        boxes_start (make_boxes_start dimy dimx)
        ;;boxes_bottom_out (make_boxes_bottom_out dimy dimx)
        boxes_grid (make_boxes_grid dimy dimx)
        boxes_arranged (make_boxes_arranged dimy dimx)
        std_chans (ncchannels_set_bg_rgb 0 0x000000)]

    (NC/ncplane_set_base plane " " 0 std_chans)

    ;;(reposition_planes box_planes boxes_arranged)

    (run_serial_transition ncs 300e6
      (fn render [i diff duration]
        (reposition_plane (get box_planes i) (transition_box (get boxes_start i) (get boxes_grid i) duration diff))
        (draw_boxes_bordered box_planes)))

    (run_transition ncs 1000e6 nil
      (fn render [_ctx diff duration]
        (dotimes [i BOX_NUM]
          (reposition_plane (get box_planes i) (transition_box (get boxes_grid i) (get boxes_arranged i) duration diff))
          (draw_boxes_bordered box_planes))))

    (run_serial_transition ncs 150e6
      (fn render [i diff duration]
        (let [plane (get box_planes i)
              chans (-> 0
                      (ncchannels_set_bchannel (transition_rgb 0x333333 0x000000 duration diff))
                      (ncchannels_set_fchannel (transition_rgb 0xF2F2F2 0x000000 duration diff)))]
          (nc-err (NC/ncplane_set_base plane " " 0 chans))
          (draw_boxes_bordered box_planes))))

    (run_serial_transition ncs 150e6
      (fn render [i diff duration]
        (let [plane (get box_planes i)
              chans (ncchannels_set_bchannel 0 (transition_rgb 0x000000 (get box_colors i) duration diff))]
          (nc-err (NC/ncplane_set_base plane " " 0 chans))
          (NC/ncplane_erase plane))))

    (run_serial_transition ncs 150e6
      (fn render [i diff duration]
        (let [plane (get box_planes i)
              ur (bit-or (transition_rgb (get box_colors i) 0xffffff duration diff) (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
              ul (bit-or (get box_colors i) (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
              lr (bit-or (get box_colors i) (.intValueExact NCConstants/NC_BGDEFAULT_MASK))
              ll (bit-or (transition_rgb (get box_colors i) 0x000000 duration diff) (.intValueExact NCConstants/NC_BGDEFAULT_MASK))]
          (nc-err (NC/ncplane_highgradient plane ul ur ll lr (dec (NC/ncplane_dim_y plane)) (dec (NC/ncplane_dim_x plane)))))))

    (let [message_box (make_message_box plane dimy dimx)]
      (run_transition ncs 300e6 {:from (- (NC/ncplane_dim_x message_box))
                                 :to (NC/ncplane_x message_box)}
        (fn render [{:keys [from to]} diff duration]
          (let [x (linear_transition from to duration diff)]
            (nc-err (NC/ncplane_move_yx message_box (NC/ncplane_y message_box) x))))))

    ;;(NC/notcurses_getc_blocking ncs nil)
    ;;(draw_boxes_gradients box_planes)
    ;;(nc-err (NC/notcurses_render ncs))

    (let [duration 1000e6]
      (loop [iter 0
             time_start (System/nanoTime)]
        (let [t (System/nanoTime)]
          (dotimes [i BOX_NUM]
            (let [plane (get box_planes i)
                  colors [(get box_colors i)
                          0xffffff
                          (get box_colors i)
                          0x000000]
                  corners (vec (for [j (range 4)]
                                 (bit-or (.intValueExact NCConstants/NC_BGDEFAULT_MASK)
                                         (transition_rgb (get colors (mod (+ iter j) 4))
                                                         (get colors (mod (+ j iter 1) 4))
                                                         duration
                                                         (- t time_start)))))]
              (nc-err (NC/ncplane_highgradient plane
                                               (get corners 0)
                                               (get corners 1)
                                               (get corners 3)
                                               (get corners 2)
                                               (dec (NC/ncplane_dim_y plane))
                                               (dec (NC/ncplane_dim_x plane))))
              (nc-err (NC/notcurses_render ncs))
              (sleep_until_ns (+ t step_ns))))

          (let [keypress (NC/notcurses_getc_nblock ncs nil)]
            (when (not= keypress (int \q))
              (if (< t (+ time_start duration))
                (recur iter time_start)
                (recur (inc iter) (System/nanoTime))))))))

    (NC/notcurses_stop ncs)))
