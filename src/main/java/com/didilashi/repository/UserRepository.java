package com.didilashi.repository;

import org.springframework.data.repository.CrudRepository;

import com.didilashi.bean.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
