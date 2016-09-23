(ns catfacts.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[catfacts started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[catfacts has shut down successfully]=-"))
   :middleware identity})
