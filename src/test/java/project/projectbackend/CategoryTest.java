package project.projectbackend;


import static org.junit.Assert.*;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.model.Category;

public class CategoryTest
{
	
	private static CategoryDao categoryDao;
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
	ConfigAppLnContext.scan("com.");
	ConfigAppLnContext.refresh();
	//SessionFactory sessionFactory=(ConfigAppLnContext.getBean(requiredType, args))
  categoryDao=(CategoryDao)ConfigAppLnContext.getBean("categoryDao");

}

@Test
public void addCategoryTest()
{
Category category= new Category();
category.setCatId(1001);
category.setCatName("sa");
category.setCatDesc("this");
assertTrue(categoryDao.addCategory(category));
}

}
