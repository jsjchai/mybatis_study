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
		// ���� mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		InputStream inputStream=MyBatisTest.class.getClassLoader().getResourceAsStream(resource);
		//Reader reader = Resources.getResourceAsReader(resource);
		// ���� sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// ������ִ��ӳ���ļ��� sql �� sqlSession
		SqlSession session = sessionFactory.openSession();
		// ӳ��sql �ı�ʶ�ַ���
		String sql = "com.mybatis.model.userMapper.getUserById";
		// ִ�в�ѯ����һ��Ψһ user ����� sql 
		User user =session.selectOne(sql, 1);
		System.out.println(user);

	}
}
