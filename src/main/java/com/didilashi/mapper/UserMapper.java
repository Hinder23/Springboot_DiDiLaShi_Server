package com.didilashi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.didilashi.bean.User;

public interface UserMapper {
	
	@Select("select * from user")
	public List<User> findUsers();
	
	@Select("select * from user where username=#{username}")
	public User getOne(String name);
	
	@Select("select name from user where id=#{id}")
	public String getNameById(int id);

}
