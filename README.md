# mapreduce

{{{
MapReduce is a programming model / pattern
usage example(s): data too big

map: collX -> collY       (note: different types)
usage example(s): clean up operation, shifting, filtering, normalizing (WVT)

reduce: collY -> value
usage example(s): abstraction; sampling(?)

Programming is about Composition: TODO find the video of Bartosz Millewski
usage example(s): transducers, monads

The Code: mapreduce.clj (Clojure) / mapreduce.py (Python)

Real World example(s): opinion polling, election survey, benchmarking(?)

MapReduce at Google
Papers & Slides
- http://static.googleusercontent.com/media/research.google.com/en/us/archive/mapreduce-osdi04.pdf
- https://research.google.com/archive/mapreduce-osdi04-slides/index.html

Apache Hadoop https://mapr.com/products/apache-hadoop/
distributed processing of large data sets across clusters of computers using simple programming models

* s/MapReduce/Cloud Dataflow/     Reasons:
- hard to ingest data rapidly
- (too) many different technologies
- batch & streaming unrelated
- deployment & operation of clusters always required
https://www.datacenterknowledge.com/archives/2014/06/25/google-dumps-mapreduce-favor-new-hyper-scale-analytics-system
}}}


## The data

2017 Yellow Taxi Trip Data | NYC Open Data (87 MB)
```
wget https://gist.github.com/kovrus/328ba1b041dfbd89e55967291ba6e074/raw/7818724cb64a5d283db7f815737c9e198a22bee4/nyc-yellow-taxi-2017.tar.gz
```

2018 Yellow Taxi Trip Data | NYC Open Data - CSV for Excel (Europe)
https://data.cityofnewyork.us/api/views/biws-g3hs/rows.csv?accessType=DOWNLOAD&bom=true&format=true&delimiter=;


## Usage

FIXME

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
