(ns demo.hello
  (:gen-class)
  (:import (com.dundalek.notcurses.swig NC notcurses_options)
           (cz.adamh.utils NativeUtils)))

(defn -main []
  (NativeUtils/loadLibraryFromJar (str "/" (System/mapLibraryName "notcurses-jni")))

  ; (println "NC version:" (NC/notcurses_version)))

  (let [opts (notcurses_options.)
        ncs (NC/notcurses_core_init opts nil)
        plane (NC/notcurses_stdplane ncs)
        message "Hello from swig JNI!"]
    (NC/ncplane_putstr_yx plane 1 2 message)
    (NC/notcurses_render ncs)

    (NC/notcurses_render ncs)

    ; (NC/notcurses_getc_nblock ncs nil)
    (Thread/sleep 1000)

    (NC/notcurses_stop ncs)))

