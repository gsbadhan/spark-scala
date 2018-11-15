# spark-scala

installation:
download: spark-2.4.0-bin-hadoop2.7.tgz

extract: tar -xvf spark-2.4.0-bin-hadoop2.7.tgz

create soft link: ln -s spark-2.4.0-bin-hadoop2.7 spark

set path in ".bash_profile": export SPARK_HOME="directory path of soft link/spark"
export PATH=$PATH:$SPARK_HOME:$SPARK_HOME/bin:$SPARK_HOME/sbin


Test spark using console:
~/spark-shell
scala> sc.textFile("/users/abc/test.json").count()


