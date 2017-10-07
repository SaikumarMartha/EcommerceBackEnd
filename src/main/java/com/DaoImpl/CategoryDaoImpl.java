package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDao;
import com.model.Category;
@Repository("CategoryDao")
public  class CategoryDaoImpl implements CategoryDao
{
@Autowired
SessionFactory sessionFactory;

@Transactional
@Autowired
public boolean addCategory(Category category)
{
	  try
      {
      sessionFactory.getCurrentSession().save(category);
      return true;
      }
      catch(Exception e)
      {
return false;	
}
	  }
@Autowired
 public List<Category> retrieveCategory()
 {
	 Session session=sessionFactory.openSession();
     Query query=session.createQuery("from Category");
     List<Category> listCategory=query.list();
     session.close();
     return listCategory;
 }
@Autowired
 public boolean deleteCategory(Category category)
 {
	 try
     {
     sessionFactory.getCurrentSession().delete(category);
     return true;
     }
     catch(Exception e)
     {
     System.out.println("Exception Arised:"+e);  
     return false;
     }
 }
public Category getCategory(int catId)
{
	 Session session=sessionFactory.openSession();
     Category category=(Category)session.get(Category.class,catId);
     session.close();
     return category;
}
public boolean updateCategory(Category category)
{
	 try
     {
     sessionFactory.getCurrentSession().saveOrUpdate(category);
     return true;
     }
     catch(Exception e)
     {
     System.out.println("Exception Arised:"+e);
     return false;
     }
 }
}


