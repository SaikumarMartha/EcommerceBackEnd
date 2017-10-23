package com;








import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.model.Product;








public class ProductTest

{
	private static ProductDao productDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
		ConfigAppLnContext.scan("com");
		ConfigAppLnContext.refresh();
		//SessionFactory sessionFactory=(Conf.getBean(requiredType, args))
		productDao=(ProductDao)ConfigAppLnContext.getBean("productDao");

	}
@Ignore
	@Transactional
	@Test
	public void addProductTest()
	{
		 Product product= new Product();
		 product.setProductId(1001);
		 product.setProductName("sa");
		 product.setProductDesc("this");
		 product.setPrice(2000);
		 product.setStock(25);
		 product.setCatId(1001);
		 product.setSupplierId(1001);
		 assertTrue("problem in insertion",productDao.addProduct(product));
	}
	
	@Ignore
	@Test
	
	public void updateProductTest()
	{
		 Product product= new Product();
		 product.setProductId(1001);
		 product.setProductName("sa");
		 product.setProductDesc("this");
		 product.setPrice(2000);
		 product.setStock(25);
		 product.setCatId(1001);
		 product.setSupplierId(1001);
		 assertTrue("problem in insertion",productDao.updateProduct(product));
	}
}


