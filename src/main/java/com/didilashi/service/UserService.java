package com.didilashi.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didilashi.bean.User;
import com.didilashi.mapper.UserMapper;
import com.didilashi.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	public User getOne(String name){
		return userMapper.getOne(name);
	}
	
	
	
	@Transactional
	public  void save(User user){
		userRepository.save(user);
	}
	@Transactional
	public void delete(int id){
		userRepository.delete(id);
	}
	
	public Iterable<User> getAll(){
		return userRepository.findAll();		
	}
	
	public Iterable<User> findByPhone(String phone){
		return userRepository.findByPhone(phone);		
	}
	public User findByUsername(String username){
		return userRepository.findByUsername(username);		
	}
	
	public User qFind(String username){
		return userRepository.QFind(username);		
	}
}
