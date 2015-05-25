(ns hisproxy.db.core
  (:use korma.core
        [korma.db :only [defdb with-db]])
  (:require
    [yesql.core :refer [defqueries]]
    [clojure.java.io :as io]))

(def db-store (str (.getName (io/file ".")) "/site.db"))

(def db-spec
  {:classname   "org.h2.Driver"
   :subprotocol "h2"
   :subname     db-store
   :make-pool?  true
   :naming      {:keys   clojure.string/lower-case
                 :fields clojure.string/upper-case}})
;bsoft_his/mm25pars8522@192.168.90.88:1521/sxwlxy
(def db-oracle-his  {:classname "oracle.jdbc.OracleDriver"
                 :subprotocol "oracle"
                 :subname "thin:@192.168.90.88:1521:sxwlxy"
                 :user "bsoft_his"
                 :password "mm25pars8522"
                 :naming {:keys clojure.string/lower-case :fields clojure.string/upper-case}})

(defqueries "sql/queries.sql" {:connection db-spec})


(defn test [mzhm]

  (with-db db-oracle-his
    (exec-raw ["select  jzxh from  V_EMR_MZ_JZJL WHERE mzhm=? and rownum<20 " [mzhm]] :results)
    )

  )
