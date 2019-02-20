(ns mapreduce.core
  (:require [clojure.data.json :as json]))

(def file "nyc-yellow-taxi-2017.head1000.json")
(with-open [rdr (clojure.java.io/reader file)]
  (count (line-seq rdr)))

(defn foo
  "I don't do a whole lot."
  []
  (->> file
       slurp
       json/read-str
       #_(take 20)))

(defn bar
  "I don't do a whole lot."
  []
  (->> file
       slurp
       json/read-str
       #_(take 20)))

(def data (remove string? (map (fn [l] (->> l second)) (bar))))
(reduce +
        data)


(defn average
  [numbers]
  (/ (apply + numbers) (count numbers)))

(average data)

