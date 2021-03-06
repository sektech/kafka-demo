package com.training.kafka_project_demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderProducer {
	
	public static void main(String[] args) {
		
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		KafkaProducer<String, Integer> producer = new KafkaProducer<>(props);
		
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("OrderTopic", "New Order",12);
		try {
			 producer.send(record, new Callback() {
				 @Override
					public void onCompletion(RecordMetadata metadata, Exception exception) {
						// TODO Auto-generated method stub
						if(metadata!=null) {
							System.out.println(metadata.partition());
							System.out.println(metadata.offset());	
						}
						if(exception != null) {
							System.out.println(exception);
						}
					}

			 });
			//System.out.println(recordMetadata.partition());
			//System.out.println(recordMetadata.offset());
			System.out.println("Message sent successfully");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			producer.close();
		}
		
	}

}
