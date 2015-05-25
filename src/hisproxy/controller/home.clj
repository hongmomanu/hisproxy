
(ns hisproxy.controller.home

  (:require [hisproxy.db.core :as db]
            [noir.response :as resp]
            )
  )

(defn test [mzhm]

  (resp/json (db/test mzhm))

  )
