package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.User;

public class MyBatisTest {

	public static void main(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml"; 
		// 加载 mybatis 的配置文件（它也加载关联的映射文件）
		InputStream inputStream=MyBatisTest.class.getClassLoader().getResourceAsStream(resource);
		//Reader reader = Resources.getResourceAsReader(resource);
		// 构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 创建能执行映射文件中 sql 的 sqlSession
		SqlSession session = sessionFactory.openSession();
		// 映射sql 的标识字符串
		String sql = "com.mybatis.model.userMapper.getUserById";
		// 执行查询返回一个唯一 user 对象的 sql 
		User user =session.selectOne(sql, 1);
		System.out.println(user);

	}
}
