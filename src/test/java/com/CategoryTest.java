package com;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.Dao.CategoryDao;
import com.model.Category;


@Ignore
public class CategoryTest
{
@Autowired
	 static CategoryDao categoryDao;
	
@BeforeClass
public static void initialize()
{
	
	System.out.println("Inside initialize");
	AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
	ConfigAppLnContext.scan("com");
	ConfigAppLnContext.refresh();
	
  categoryDao=(CategoryDao)ConfigAppLnContext.getBean("categoryDao");

}

@Ignore

@Test
public void addCategoryTest()
{
Category category= new Category();
category.setCatId(121);
category.setCatName("martha");
category.setCatDesc("abcd");
assertTrue(categoryDao.addCategory(category));
}

@Ignore

@Test
public void updateCategoryTest()
{
    Category category=new Category();
    category.setCatId(120);
    category.setCatName("JMShirt");
    category.setCatDesc("John Miller Shirt with Best Price");
     
    assertTrue(categoryDao.updateCategory(category));
}

@Ignore
public void retrieveCategoryTest()
{
	/*List<Category> listCategory=categoryDao.retrieveCategory();
	assertNotNull("Problem in Retriving ",listCategory);
	this.show(listCategory);*/
}


@Ignore
@Test
public void getCategoryTest()
{
	Category category=categoryDao.getCategory(120);
	assertNotNull("Problem in Getting:",category);
	System.out.println("Category ID:"+category.getCatId());
	System.out.println("Category Name:"+category.getCatName());
	System.out.println("Category Description  = "+category.getCatDesc());
}



}
