(ns mapreduce.crate
  (:require
   [clojure.java.jdbc :as jdbc]
   [clj-dbcp.core :as dbcp]
   [clojure.core.memoize :as memo])
  #_(:use
     [korma.db]
     [korma.core]))

(def db {:classname "io.crate.client.jdbc.CrateDriver"
         :jdbc-url "crate://localhost:5432/"
         :user "crate" :password ""})

(defn dbquery-impl [sql]
  (jdbc/with-db-connection [con {:datasource (dbcp/make-datasource db)}]
    (jdbc/query con [sql])))

(def dbquery
  #_dbquery-impl
  (memo/memo dbquery-impl))

(defn from-230 [id]
  (dbquery
   "
select
  count(*) cnt
from taxi_rides where
pickup_location_id ='230'"))
;; => ({:cnt 139492})

(defn round-trip []
  (dbquery
   ;; https://commons.wikimedia.org/wiki/File:SQL_Joins.svg
   "SELECT *
FROM taxi_rides a INNER JOIN taxi_rides b ON a._id != b._id
AND a.pickup_location_id = b.dropoff_location_id
AND a.dropoff_location_id = b.pickup_location_id
AND a.pickup_location_id ='79'
LIMIT 10
"))
