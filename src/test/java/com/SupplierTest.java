package com;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;

import com.model.Supplier;




public class SupplierTest
{
	
	@Autowired
	private static SupplierDao supplierDao;
	@BeforeClass

	public static void initialize()
	{
		AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
		ConfigAppLnContext.scan("com");
		ConfigAppLnContext.refresh();
		
	  supplierDao=(SupplierDao)ConfigAppLnContext.getBean("supplierDao");

	}
	@Transactional
	@Ignore
	@Test
	
	public void addSupplierTest()
	{
		Supplier supplier= new Supplier();
		supplier.setSupplierId(1001);
		supplier.setSupplierName("ashes");
		supplier.setSupplierAddress("cricket");
		
		assertTrue(supplierDao.addSupplier(supplier));
	}
	

	
	@Ignore
	
	 @Test
	    public void updateSupplierTest()
	    {
	        Supplier supplier=new Supplier();
	        supplier.setSupplierId(1001);
	        supplier.setSupplierName("JMShirt");
	        supplier.setSupplierAddress("John Miller Shirt with Best Price");
	         
	        assertTrue(supplierDao.updateSupplier(supplier));
	    }
	 
	 
	 @Ignore
	 @Test
	 public void getSupplierTest()
	 {
	 	Supplier supplier=supplierDao.getSupplier(1001);
	 	assertNotNull("Problem in Getting:",supplier);
	 	System.out.println("supplier ID:"+supplier.getSupplierId());
	 	System.out.println("supplier Name:"+supplier.getSupplierName());
	 	System.out.println("supplier Description  = "+supplier.getSupplierAddress());
	 }
	
}
