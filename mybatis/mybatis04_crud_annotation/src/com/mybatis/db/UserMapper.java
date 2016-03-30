package com.mybatis.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.model.User;

public interface UserMapper {

	@Insert("insert into user (name,age,address) values(#{name},#{age},#{address})")
	public void add(User user);
	
	@Delete("delete from user where id=#{id}")
	public void delete(int id);
	
	@Update("update user set name=#{name},age=#{age},address=#{address} where id=#{id}")
	public void update(User user);

	@Select("select * from user where id=#{id}")
	public User getUserById(int id);
	
	@Select("select * from user")
	public List<User> findAll();
}
