package com.mybatis.dao;

import java.util.List;

import com.mybatis.model.User;

public interface UserMapper {

	void save(User user);
	
	void update(User user);
	
	void delete(int id);
	
	User findById(int id);
	
	List<User> findAll();
}
