package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public boolean addSupplier(Supplier supplier) {
		  try
	      {
	      sessionFactory.getCurrentSession().save(supplier);
	      return true;
	      }
	      catch(Exception e)
	      {
	return false;	
	}
	}

	@Override
	public List<Supplier> retrieveSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier)
	{
		 try
	     {
	     sessionFactory.getCurrentSession().delete(supplier);
	     return true;
	     }
	     catch(Exception e)
	     {
	     System.out.println("Exception Arised:"+e);  
	     return false;
	     }
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		 Session session=sessionFactory.openSession();
		 Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
	     session.close();
	     return supplier;
	}

	@Override
	public boolean updateSupplier(Supplier supplier)
	{
		try
	     {
	     sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	     return true;
	     }
	     catch(Exception e)
	     {
	     System.out.println("Exception Arised:"+e);
	     return false;
	     }
	}
	
	}
