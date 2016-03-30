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

import com.mybatis.db.UserMapper;
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
		UserMapper mapper= session.getMapper(UserMapper.class);
		User user=mapper.getUserById(2);
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testAdd(){
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		User user=new User();
		user.setName("李四");
		user.setAge(21);
		user.setAddress("上海");
		mapper.add(user);
		session.commit();
		session.close();
	}
	@Test
	public void testUpdate(){
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		User user =mapper.getUserById(3);
		user.setAge(25);
		mapper.update(user);
		session.commit();
		session.close();
	}
	@Test
	public void testDelete(){
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		mapper.delete(3);
		session.commit();
		session.close();
	}
	@Test
	public void testFindAll(){
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		List<User> userList=mapper.findAll();
		for(User user:userList){
			System.out.println(user);
		}
		session.close();
	}
}
