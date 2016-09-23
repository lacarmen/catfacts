(ns catfacts.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [catfacts.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[catfacts started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[catfacts has shut down successfully]=-"))
   :middleware wrap-dev})
