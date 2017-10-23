package com;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*@Ignore
@ComponentScan("com.model")

public class AppTest 
{
	@SuppressWarnings("unused")
	@Autowired
	private static UserDao userDao;
	

@SuppressWarnings("resource")
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.register(DataBaseConfig.class);
	context.refresh();
	
///	user = (User) context.getBean("user");
	userDao = (UserDao) context.getBean("userDao");
}
	
	
	
}*/
