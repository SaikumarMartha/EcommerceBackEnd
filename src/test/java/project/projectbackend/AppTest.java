package project.projectbackend;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Dao.UserDao;
import com.hibernateConfig.DataBaseConfig;

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
	
	
	
}
