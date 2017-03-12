package com.didilashi.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didilashi.bean.User;
import com.didilashi.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/save")
	public String save(){
		User user=new User();
		user.setPhone("18758578355");
		user.setUsername("Marvin");
		user.setPassword("123456");
		userService.save(user);
		return "Save ok";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		userService.delete(1);
		return "delete ok";
	}
	
	@RequestMapping("/findAll")
	public Iterable<User> findAll(){	
		return userService.getAll();	
		
	}
	
}
