package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

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
	public void testCacheOne1() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.getUserById";
		User user1=session.selectOne(statement, 5);
		System.out.println(user1);
		
		User user2=session.selectOne(statement, 5);
		System.out.println(user2);
		
		//清除一级缓存 
		session.clearCache();
		
		User user3=session.selectOne(statement, 5);
		System.out.println(user3);
		session.close();
	}
	@Test
	public void testCacheOne2() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.getUserById";
		User user1=session.selectOne(statement, 5);
		System.out.println(user1);
		
		User user2=session.selectOne(statement, 5);
		System.out.println(user2);
		
		//执行c/u/d 
		User user3=session.selectOne(statement, 5);
		user3.setAge(55);
		session.update("com.mybatis.model.userMapper.update", user3);
		
		System.out.println(session.selectOne(statement, 5));
		session.close();
	}
	@Test
	public void testCacheOne3() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.getUserById";
		User user1=session.selectOne(statement, 5);
		System.out.println(user1);
		
		//关闭session
		session.close();
		session = sqlSessionFactory.openSession();
		
		User user2=session.selectOne(statement, 5);
		System.out.println(user2);
		
	}


	
}
