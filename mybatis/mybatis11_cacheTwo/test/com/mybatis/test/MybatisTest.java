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
	public void testCacheTwo() {
		SqlSession session1 = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.getUserById";
		User user1=session1.selectOne(statement, 5);
		session1.commit();
		System.out.println(user1);
		
		SqlSession session2 = sqlSessionFactory.openSession();
		User user2=session2.selectOne(statement, 5);
		session2.commit();
		System.out.println(user2);
		
		
	}
	

	
}
