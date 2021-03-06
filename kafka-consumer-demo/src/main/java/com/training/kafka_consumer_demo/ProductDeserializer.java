package com.training.kafka_consumer_demo;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductDeserializer implements Deserializer<Product> {

	@Override
	public Product deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		Product product = null;
		try {
			product = mapper.readValue(data, Product.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

}
