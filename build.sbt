
name := "spark-scala"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"

scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8", "-Xlint")
excludeFilter in unmanagedSources := (HiddenFileFilter || "*-script.scala")
unmanagedResourceDirectories in Compile += baseDirectory.value / "conf"
unmanagedResourceDirectories in Test += baseDirectory.value / "conf"


val sparkVersion        = "2.4.2"
val scalaTestVersion    = "3.0.7"
val scalaCheckVersion   = "1.14.0"
val sparkStreamingKafka = "2.4.2"

libraryDependencies ++= Seq(
  "org.apache.spark"  %% "spark-core"      					% sparkVersion,
  "org.apache.spark"  %% "spark-streaming" 					% sparkVersion,
  "org.apache.spark"  %% "spark-streaming-kafka-0-10" 		% sparkStreamingKafka,
  "org.apache.spark"  %% "spark-sql"       					% sparkVersion,
  "org.apache.spark"  %% "spark-hive"      					% sparkVersion,
  "org.apache.spark"  %% "spark-repl"      					% sparkVersion,
  "org.scalatest"     %% "scalatest"       					% scalaTestVersion  % "test",
  "org.scalacheck"    %% "scalacheck"      					% scalaCheckVersion % "test")
