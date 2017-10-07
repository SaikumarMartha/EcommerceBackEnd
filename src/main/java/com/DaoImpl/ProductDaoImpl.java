package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.model.Category;
import com.model.Product;
@Repository("productDao")
public class ProductDaoImpl implements ProductDao 
{
	@Autowired
    SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public boolean addProduct(Product product) 
	{
		 try
	      {
	      sessionFactory.getCurrentSession().save(product);
	      return true;
	      }
	      catch(Exception e)
	      {
	      return false;
	      }
	}

	@Override
	public List<Product> retrieveProduct()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(Product product)
	{
		 try
	     {
	     sessionFactory.getCurrentSession().delete(product);
	     return true;
	     }
	     catch(Exception e)
	     {
	     System.out.println("Exception Arised:"+e);  
	     return false;
	     }
	}

	@Override
	public Product getProduct(int productId) 
	{
		 Session session=sessionFactory.openSession();
		 Product product=(Product)session.get(Product.class,productId);
	     session.close();
	     return product;
	}

	@Override
	public boolean updateProduct(Product product)
	{
		try
	     {
	     sessionFactory.getCurrentSession().saveOrUpdate(product);
	     return true;
	     }
	     catch(Exception e)
	     {
	     System.out.println("Exception Arised:"+e);
	     return false;
	     }
	}

}
