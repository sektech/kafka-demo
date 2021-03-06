package com.training.kafka_project_demo;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductSerializer implements Serializer<Product>{

	@Override
	public byte[] serialize(String topic, Product data) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		byte[] bytes = null;
		try {
			bytes = mapper.writeValueAsString(data).getBytes();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return bytes;
	}

}
