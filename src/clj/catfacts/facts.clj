(ns catfacts.facts
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [mount.core :refer [defstate]]
            [catfacts.config :refer [env]]))

(defn load-facts []
  (let [facts (-> (or
                    (:facts env)
                    (io/resource "facts.edn"))
                  (slurp)
                  (edn/read-string))]
    {:facts facts
     :fact-count (count facts)}))

(defstate facts :start (load-facts))

(defn catfact []
  (let [idx (rand-int (:fact-count facts))
        fact (get-in facts [:facts idx])]
    (str "Cat Fact " (inc idx) ": " fact "\n:cat: :cat: :cat:")))
