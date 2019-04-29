package com.demp.kafka.consumer

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.KafkaUtils
import scala.collection.mutable.Subscriber
import org.apache.spark.streaming.kafka010.PreferConsistent
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka010.LocationStrategies
import org.apache.spark.streaming.kafka010.ConsumerStrategies

object ConsumeEvents {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ConsumeEvents").setMaster("local[*]")
    val ssc = new StreamingContext(conf, Seconds(2))

    val topics = Array("testkeyhash")
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "test_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (true: java.lang.Boolean))

    val messages = KafkaUtils.createDirectStream[String, String](
      ssc, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](topics, kafkaParams))

    print("consumer: ", messages)

    ssc.start()
    ssc.awaitTermination()
  }
}