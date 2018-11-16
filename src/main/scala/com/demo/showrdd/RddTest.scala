package com.demo.showrdd

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.collection.Seq

object RddTest {
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RddTest").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("src/main/scala/com/demo/showrdd/data.txt")
    val data =lines.flatMap(line => {
      val chunk = line.split(",")
      Seq(new Tempdata(chunk(0).toInt, chunk(1).toString(),chunk(2).toInt))
    })
    //put into cache
    data.cache();
    
    data.take(data.count().toInt) foreach println
    
    println("total records:"+ data.count())
    println("min age:"+ data.min()(Ordering.by(t=>t.age)))
    println("max age:"+ data.max()(Ordering.by(t=>t.age)))
    
  }
  
}