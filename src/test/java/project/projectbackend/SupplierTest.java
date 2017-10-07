package project.projectbackend;



import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;


public class SupplierTest
{
	private static SupplierDao supplierDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
		ConfigAppLnContext.scan("com.");
		ConfigAppLnContext.refresh();
		//SessionFactory sessionFactory=(Conf.getBean(requiredType, args))
	  supplierDao=(SupplierDao)ConfigAppLnContext.getBean("supplierDao");

	}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier= new Supplier();
		supplier.setSupplierId(1001);
		supplier.setSupplierName("sa");
		supplier.setSupplierAddress("this");
		
		assertTrue(supplierDao.addSupplier(supplier));
	}
	
}
