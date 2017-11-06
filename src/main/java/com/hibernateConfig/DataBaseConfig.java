package com.hibernateConfig;




import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.AddressDao;
import com.Dao.CartDao;
import com.Dao.UserDao;
import com.DaoImpl.AddressDaoImpl;
import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.UserDaoImpl;


import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class DataBaseConfig 
{
	// user Database
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/gt");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Datasource");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	//	properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}
	//Session Factory Bean Created.
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com");
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}
	//Transaction Bean Object
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
@Autowired
@Bean(name = "userDao")
public UserDao getUserDao(SessionFactory sessionFactory)
{

	return new UserDaoImpl(sessionFactory);
}
	

@Autowired
@Bean(name = "cartDao")
public CartDao getCartDao(SessionFactory sessionFactory)
{

	return new CartDaoImpl(sessionFactory);
}
@Autowired
@Bean(name = "addressDao")
public AddressDao getAddressDao(SessionFactory sessionFactory)
{

	return new AddressDaoImpl(sessionFactory);
}
}


















	

















