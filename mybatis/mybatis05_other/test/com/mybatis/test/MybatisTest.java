package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.model.User;

public class MybatisTest {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void initFactory() throws IOException {
		String resource = "sqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetUserById(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.mybatis.model.userMapper.getUserById";
		User user =session.selectOne(statement, 1);
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testAdd(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.mybatis.model.userMapper.add";
		User user=new User();
		user.setName("张三");
		user.setAge(21);
		user.setAddress("北京");
		session.insert(statement, user);
		session.commit();
		session.close();
	}
	@Test
	public void testUpdate(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement1="com.mybatis.model.userMapper.getUserById";
		User user =session.selectOne(statement1, 1);
		user.setAge(25);
		String statement2="com.mybatis.model.userMapper.update";
		session.update(statement2,user);
		session.commit();
		session.close();
	}
	@Test
	public void testDelete(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.mybatis.model.userMapper.delete";
		session.delete(statement, 1);
		session.commit();
		session.close();
	}
	@Test
	public void testFindAll(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement1="com.mybatis.model.userMapper.findAll";
		List<User> userList=session.selectList(statement1);
		for(User user:userList){
			System.out.println(user);
		}
		session.close();
	}
}
