package com.mybatis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;

@RunWith(SpringJUnit4ClassRunner.class) // π”√Springtest≤‚ ‘øÚº‹
@ContextConfiguration("/applicationContext.xml") //º”‘ÿ≈‰÷√
public class MybatisTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSave(){
		User user=new User();
		user.setName("’≈∑…");
		user.setAge(25);
		user.setAddress("…Ó€⁄");
		userMapper.save(user);
	}
	
	@Test
	public void testDelete(){
	
		userMapper.delete(17);
	}
}
