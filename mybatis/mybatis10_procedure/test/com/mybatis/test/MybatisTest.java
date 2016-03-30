package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
	public void testCount() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.mybatis.model.userMapper.count";
		Map<String,Integer> map=new HashMap<String, Integer>();
		//0 北京  1上海
		map.put("checked", 0);
		map.put("countByAddress", 0);
		session.selectOne(statement, map);
		int count=map.get("countByAddress");
		System.out.println(count);
		session.close();
	}


	
}
