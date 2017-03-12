package com.didilashi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.didilashi.bean.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByPhone(String phone);
	public User findByUsername(String username);	
	@Query("from User where username=:username")
	public User QFind(@Param("username")String username);
	
}
