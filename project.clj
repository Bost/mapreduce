(defproject org.clojars.bost/mapreduce :lein-v
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies
  [
   [org.clojure/clojure "1.10.0"]
   [org.clojure/data.json "0.2.6"]
   [io.crate/crate-jdbc "2.5.1"]
   [com.mchange/c3p0 "0.9.5.3"] ; db connection pooling
   [org.clojure/java.jdbc "0.7.9"]
   [clj-dbcp "0.9.0"] ; JDBC connections pools
   [org.clojure/core.memoize "0.7.1"]
   ;; [korma "0.4.0"] ;; sql for clojure
   ]
  :repositories {"crate-jdbc" "https://dl.bintray.com/crate/crate/"}
  :repl-options {:init-ns mapreduce.mapreduce}
  :plugins
  [
   ;; autorecompile changed java files
   ;; [lein-virgil "0.1.9"]

   ;; drive leiningen project version from git
   [com.roomkey/lein-v "7.0.0"]
   ]
  ;; :java-source-paths ["src"]
  :resource-paths ["src/main/resources"]
)
