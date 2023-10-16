(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def uber-file "target/demo.jar")

(defn clean [_]
  (b/delete {:path class-dir}))

(defn uber [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["target/native"]
               :target-dir class-dir})
  (b/javac {:src-dirs ["src/java"]
            :class-dir class-dir
            :basis basis})
  (b/compile-clj {:basis basis
                  :src-dirs ["src/clj"]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis
           :main 'demo.main}))
           ; :main 'demo.hello}))
