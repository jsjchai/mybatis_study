package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void initFactory() throws IOException {
		String resource = "sqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetById(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.mybatis.model.baseMapper.getByWife";
		System.out.println(session.selectOne(statement, 7));
		session.close();
		//System.out.println(husband);
	}
	@Test
	public void testGetById2(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.mybatis.model.baseMapper.getHusband";
		System.out.println(session.selectOne(statement, 4));
		session.close();
	}
}
