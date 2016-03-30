package com.mybatis.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestMybatis {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void initFactory() throws IOException {
		String resource = "sqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testListAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("com.mybatis.model.listAll");
		System.out.println(users.size());
	}

	@Test
	public void testQueryOne() {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("com.mybatis.model.getOne", 1);
		System.out.println(user);
	}

	// 事务需要程序员处理
	@Test
	public void testInsertOne() {
		User u = new User();
		u.setId(UUID.randomUUID().toString());
		u.setName("sbsbb");
		u.setAge(18);
		u.setAddress("china");
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.insert("com.mybatis.model.insertOne", u);
		session.commit();
		System.out.println(count);
	}

	@Test
	public void testUpdateOne() {
		SqlSession session = sqlSessionFactory.openSession();
		User u = new User();
		// u=session.selectOne("com.mybatis.model.getOne", "2");
		u.setId("2");
		u.setName("clclclclclcfei");
		u.setAge(100);
		u.setAddress("USA");
		int count = session.update("com.mybatis.model.updateOne", u);
		session.commit();
		System.out.println(count);
	}

	@Test
	public void testDeleteOne() {
		SqlSession session = sqlSessionFactory.openSession();
		User u = new User();
		u.setId("2");
		int count = session.delete("com.mybatis.model.deleteOne", u);
		session.commit();
		System.out.println(count);
	}

}