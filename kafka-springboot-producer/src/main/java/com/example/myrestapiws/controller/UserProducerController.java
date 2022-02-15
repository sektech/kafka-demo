package com.example.myrestapiws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myrestapiws.model.User;
import com.example.myrestapiws.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserProducerController {

		@Autowired
		private UserService userService;
		
		@PostMapping("/publicUserData/{name}/{age}")
		public void sendUserData(@PathVariable String name,@PathVariable Integer age) {
		
			userService.sendUserData(name, age);
		}
	

		@PostMapping("/publicUserData")
		public void sendUser(@RequestBody User user) {
		
			userService.sendUser(user);
		}
	
}
