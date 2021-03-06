package com.training.kafka_consumer_demo;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

public class ProductConsumer {
	
	   public static void main( String[] args )
	    {
		   System.out.println("Consumer");
	    	Properties props = new Properties();
			props.setProperty("bootstrap.servers", "localhost:9092");
			props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.setProperty("value.deserializer", "com.training.kafka_consumer_demo.ProductDeserializer");
		
			props.setProperty("group.id", "ProductGroup");
			
			KafkaConsumer<String, Product> consumer = new KafkaConsumer<>(props);
			
			consumer.subscribe(Collections.singletonList("ProductTopic"));
			ConsumerRecords<String, Product> orders = consumer.poll(Duration.ofSeconds(20));
			for(ConsumerRecord<String, Product> order : orders) {
				System.out.println(order.key());
				System.out.println(order.value());
			}
			consumer.close();
	    }

}
