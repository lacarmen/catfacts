(ns user
  (:require [mount.core :as mount]
            catfacts.core))

(defn start []
  (mount/start-without #'catfacts.core/repl-server))

(defn stop []
  (mount/stop-except #'catfacts.core/repl-server))

(defn restart []
  (stop)
  (start))


