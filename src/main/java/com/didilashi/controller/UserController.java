package com.didilashi.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didilashi.bean.User;
import com.didilashi.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@Autowired
	private UserService userService2;

	
	
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
	
	@RequestMapping("/findByUsername")
	public User findByUsername(String username){	
		return userService.findByUsername(username);	
		
	}
	
	@RequestMapping("/QFind")
	public User qFind(String username){	
		return userService.qFind(username);	
		
	}
	@RequestMapping("/findByPhone")
	public Iterable<User> findByPhone(String Phone){	
		return userService.findByPhone(Phone);	
		
	}
	
	@RequestMapping("/update")
	public User update(String username){	
		User user= userService.findByUsername(username);	
		user.setPassword("wuxinda");
		userService.save(user);
		return user;
	}
	
	@RequestMapping("/getOne")
	public User getOne(String name){
		User user=userService2.getOne(name);
		return user;
	}
	
	
	
	
}
