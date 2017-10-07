package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Dao.*;
import com.model.*;


@Repository
public class UserDaoImpl implements UserDao
{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
	
	this.sessionFactory=sessionFactory;
		
	}

	public boolean saveUser(User user)
	{
		
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		return true;
		
		
		
		
	}



}