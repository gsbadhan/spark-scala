# spark-scala

start master:
./start-master.sh &

start slave:
./start-slave.sh spark://admins-MacBook-Pro.local:7077 &


build project:
sbt clean package

submit job to spark:
./spark-submit --class com.demo.showrdd.RddTest --master spark://admins-MacBook-Pro.local:7077 --deploy-mode cluster /Users/gurpreet.singh/git/spark-scala/target/scala-2.12/spark-scala_2.12-0.1.0-SNAPSHOT.jar 




