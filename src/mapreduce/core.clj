(ns mapreduce.core
  (:require [clojure.data.json :as json]))

;; the boiler plate code {{{
(def file "nyc-yellow-taxi-2017.head-2.json")
(defn get-lines []
  (with-open
    [rdr (clojure.java.io/reader file)]
    (->> rdr
         line-seq
         doall)))
;; }}}


;; verify the boiler plate code {{{
;; the content
(get-lines)
(def the-lines (get-lines))
;; the type
(-> the-lines first)
(-> the-lines first type)
;; }}}

;; content processing {{{
;; the first conversion - getting the content
(map json/read-str the-lines)
(def json-elems (map json/read-str the-lines))
;; verify the conversion {{{
;; the type
(type (first json-elems))
(keys (first json-elems))
(get (first json-elems) "total_amount")
;; }}}
;; }}}

;; content processing generalisation {{{
;; from single value to a collection of values
(map type json-elems)
;; analyse the type
(map keys json-elems)
;; it's a hash-map! Yay :) Let's access it:
(defn total-amount [hash-map] (get hash-map "total_amount"))
(map total-amount json-elems)
;; }}}


;; getting biiiig {{{
#_(def file "nyc-yellow-taxi-2017.json") ;; 4.000.000 lines
;; }}}


;; getting low :) {{{
;; TODO introduce scaling / sampling / etc.
;; }}}
(defn reducer
  "return average"
  [collection]
  #_(count collection)
  (/ (apply + collection) (count collection)))

(defn mapper [elem]
  ((comp
    (fn [hmap] (get hmap "tip_amount"))
    json/read-str)
   elem))

(defn map-reduce [file mapper reducer]
  (with-open [rdr (clojure.java.io/reader file)]
    (->> rdr
         line-seq
         (take 20)
         (map mapper)
         doall
         reducer
         )))

#_(map-reduce "nyc-yellow-taxi-2017.json" mapper reducer)
