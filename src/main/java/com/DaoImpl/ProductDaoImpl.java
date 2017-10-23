package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
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

	public List<Product> retrieveProduct()
	{
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Product");
        List<Product> listProduct=query.list();
        session.close();
        return listProduct;
		
	}

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

	public Product getProduct(int productId) 
	{
		 Session session=sessionFactory.openSession();
		 Product product=(Product)session.get(Product.class,productId);
	     session.close();
	     return product;
	}

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

	public Product getItem(int id) 
	{
		 Product product=sessionFactory.getCurrentSession().get(Product.class,id);
		return null;
	}

}
