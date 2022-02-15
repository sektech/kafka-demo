package com.example.myrestapiws.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.myrestapiws.model.User;

@Service
public class UserService {
	
	@KafkaListener(topics={"user-obj-topic"})
	public void consumerUserData(User user) {
		System.out.println("User :" + user);
	}
	
}
