(ns catfacts.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [catfacts.facts :refer [catfact]]))

(s/defschema CatFact {:response_type String
                      :text String})

(defapi service-routes
  {:swagger {:ui   "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version     "1.0.0"
                           :title       "Sample API"
                           :description "Sample Services"}}}}

  (GET "/" []
       :return CatFact
       :summary "Gets a Cat Fact!"
       (ok {:response_type "in_channel"
            :text (catfact)})))
