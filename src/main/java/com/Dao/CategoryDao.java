package com.Dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao 
{
public boolean addCategory(Category category);
public List<Category> retrieveCategory();
public Category deleteCategory(int category_id);
public Category getCategory(int catId);
public boolean updateCategory(Category category);
}
