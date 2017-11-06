package com;
import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.PaymentDao;
import com.model.Payment;

@Ignore


public class PaymentTest 
{
	@Autowired
	private static Payment payment;
	
	@Autowired
	private static PaymentDao paymentDao;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		paymentDao = (PaymentDao) context.getBean("paymentDao");
		
		payment = (Payment) context.getBean("payment");
		
	
	}
	
	@Test
	public void createAddressTest(){
		
		payment.setPaymentMethod("netbanking");
		payment.setUserId(4);
		payment.setTotalAmount(700);
		boolean response = paymentDao.savePaymentInfo(payment);
		assertEquals("PaymentTest",true,response);
	}
}
