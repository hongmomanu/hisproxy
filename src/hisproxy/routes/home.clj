(ns hisproxy.routes.home
  (:require [hisproxy.layout :as layout]
            [hisproxy.controller.home :as home]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))

  (GET "/test" [mzhm] (home/test mzhm))




  (GET "/about" [] (about-page)))

