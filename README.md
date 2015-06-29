UUID Generator Benchmark
------------------------

A [JMH Benchmark](http://openjdk.java.net/projects/code-tools/jmh/) comparing 3 popular java UUID generators:

* [JDK's UUID class](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [Java UUID Generator](https://github.com/cowtowncoder/java-uuid-generator) by Tatu Saloranta of FasterXML.com
* [EAIO](http://johannburkard.de/software/uuid/#maven) by Johann Burkard


### Running the Benchmarks

Benchmarks are compiled into an executable jar:
 
```
mvn clean install && java -jar target/benchmarks.jar
```


## Current Results


### Late 2013 MackBook Pro (2 GHz Core i7, 8GB RAM):

```
Benchmark                           Mode  Cnt    Score    Error  Units
EAIOBenchmark.timeAndEthernetBased    ss  100    9.630 ±  0.551  ms/op
JUGBenchmark.nameBased                ss  100   43.070 ±  4.415  ms/op
JUGBenchmark.random                   ss  100  211.918 ±  4.609  ms/op
JUGBenchmark.timeAndEthernetBased     ss  100   10.630 ±  1.061  ms/op
JUGBenchmark.timeBased                ss  100    9.678 ±  0.795  ms/op
JavaUUIDBenchmark.nameBased           ss  100  108.856 ± 18.086  ms/op
JavaUUIDBenchmark.random              ss  100  253.905 ±  6.687  ms/op
```


### Contributing

See a way to improve these benchmarks?  Submit a pull request!  Make sure you capture the results and update the README
accordingly.
