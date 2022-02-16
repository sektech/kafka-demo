package com.training.kafka_project_demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProductProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
	/*	props.setProperty("bootstrap.servers", "127.0.0.1:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "com.training.kafka_project_demo.ProductSerializer");*/
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ProductSerializer.class);
		Product product = new Product();
		product.setId(123);;
		product.setName("Coke");product.setPrice(25);
		KafkaProducer<String,Product> producer = new KafkaProducer<String, Product>(props);
		ProducerRecord<String, Product> producerRecord = new ProducerRecord<>("ProductTopic",product.getName(),product);
		try {
			producer.send(producerRecord, new Callback() {
				
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					// TODO Auto-generated method stub
					System.out.println(metadata);
					System.out.println(exception);
				}
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			producer.close();
		}
		
	}

}
