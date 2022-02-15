package com.example.myrestapiws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.myrestapiws.model.User;

@Service
public class UserService {
	
	@Autowired
	private KafkaTemplate<String, Integer> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplateuser;
	
	
	public void sendUserData(String name,int age) {
		kafkaTemplate.send("user-topic", name, age);
	}

	public void sendUser(User user) {
		// TODO Auto-generated method stub
		kafkaTemplateuser.send("user-obj-topic",user.getName(),user);
	}

}
