name := "SparkRedisConnector"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "com.redislabs" % "spark-redis" % "2.3.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1"
