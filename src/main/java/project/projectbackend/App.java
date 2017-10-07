package project.projectbackend;
//import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Dao.UserDao;
import com.hibernateConfig.DataBaseConfig;
import com.model.User;

@ComponentScan("com.spring.model")
public class App 
{
    @Autowired
    private static User user;

		@Autowired
		private static UserDao userDao;
		

	@SuppressWarnings("resource")
	//@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.*");
		context.register(DataBaseConfig.class);
		context.refresh();
		

		userDao = (UserDao) context.getBean("userDao");
	}


/*	
	public void saveUser()
	{
		User user=new User();
		user.setName("");
		
		
		
		boolean flag=userDao.saveUser(user);
		assertEquals("createUser", true, flag);

	}



	private void assertEquals(String string, boolean b, boolean flag) {
		// TODO Auto-generated method stub
		*/
	}




