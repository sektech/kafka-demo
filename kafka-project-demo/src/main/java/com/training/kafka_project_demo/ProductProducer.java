package com.training.kafka_project_demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProductProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "com.training.kafka_project_demo.ProductSerializer");
		Product product = new Product();
		product.setId(123);;
		product.setName("Coke");product.setPrice(25);
		KafkaProducer<String,Product> producer = new KafkaProducer<String, Product>(props);
		ProducerRecord<String, Product> producerRecord = new ProducerRecord<>("ProductTopic",product.getName(),product);
		try {
			producer.send(producerRecord);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			producer.close();
		}
		
	}

}
