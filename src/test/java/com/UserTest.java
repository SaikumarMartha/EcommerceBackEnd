package com;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Dao.UserDao;
import com.hibernateConfig.DataBaseConfig;

@Ignore
@ComponentScan("com")

public class UserTest 
{
	@SuppressWarnings("unused")
	@Autowired
	private static UserDao userDao;
	

@SuppressWarnings("resource")
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com");
	context.register(DataBaseConfig.class);
	context.refresh();
	
///	user = (User) context.getBean("user");
	userDao = (UserDao) context.getBean("userDao");
}
	
	
	
}
