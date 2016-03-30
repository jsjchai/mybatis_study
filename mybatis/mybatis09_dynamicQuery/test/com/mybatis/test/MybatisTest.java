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

import com.mybatis.model.QueryCondition;
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
	public void testGetUserList() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.getUserList";
		String likeCondition = "a";
		likeCondition=null;
		List<User> users = session.selectList(statement, new QueryCondition("%"
				+ likeCondition + "%", 20, 25));
		session.close();
		for(User user : users){
			System.out.println(user);
		}
	}


	
}
