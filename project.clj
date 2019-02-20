(defproject org.clojars.bost/mapreduce :lein-v
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies
  [
   [org.clojure/clojure "1.10.0"]
   [org.clojure/data.json "0.2.6"]
   ]
  :repl-options {:init-ns mapreduce.core}
  :plugins
  [
   ;; autorecompile changed java files
   ;; [lein-virgil "0.1.9"]

   ;; drive leiningen project version from git
   [com.roomkey/lein-v "7.0.0"]
   ]
)