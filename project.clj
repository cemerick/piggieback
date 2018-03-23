(defproject com.cemerick/piggieback "0.2.3-SNAPSHOT"
  :description "Adding support for running ClojureScript REPLs over nREPL."
  :url "http://github.com/cemerick/piggieback"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/tools.nrepl "0.2.10"]]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :deploy-repositories {"releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/" :creds :gpg}
                        "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/" :creds :gpg}}

  :aliases  {"all" ["with-profile" "dev"]}

  ;; painful for users; https://github.com/technomancy/leiningen/issues/1771
  :profiles {:dev {:dependencies [[org.clojure/tools.nrepl "0.2.10"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]
                                  [org.clojure/clojurescript "1.9.946" :scope "provided"]]}
             :master {:repositories [["snapshots" "https://oss.sonatype.org/content/repositories/snapshots"]]
                      :dependencies [[org.clojure/clojure "1.10.0-master-SNAPSHOT"]
                                     [org.clojure/clojurescript "1.9.946" :scope "provided"]]}

             :sysutils {:plugins [[lein-sysutils "0.2.0"]]}

             :cloverage {:plugins [[lein-cloverage "1.0.11-SNAPSHOT"]]}

             :cljfmt {:plugins [[lein-cljfmt "0.5.7"]]
                      :cljfmt  {:indents {as->                [[:inner 0]]
                                          with-debug-bindings [[:inner 0]]
                                          merge-meta          [[:inner 0]]
                                          try-if-let          [[:block 1]]}}}

             :eastwood {:plugins  [[jonase/eastwood "0.2.5"]]
                        :eastwood {:config-files ["eastwood.clj"]}}}

  ;;maven central requirements
  :scm {:url "git@github.com:cemerick/piggieback.git"}
  :pom-addition [:developers [:developer
                              [:name "Chas Emerick"]
                              [:url "http://cemerick.com"]
                              [:email "chas@cemerick.com"]
                              [:timezone "-5"]]])
