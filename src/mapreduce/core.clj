(ns mapreduce.core
  (:require [clojure.data.json :as json]))

(defn foo
  "I don't do a whole lot."
  []
  (->> "nyc-yellow-taxi-2017.head1000.json"
       slurp
       json/read-str
       #_(take 20)))

(defn bar
  "I don't do a whole lot."
  []
  (->> "nyc-yellow-taxi-2017.head1000.json"
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

