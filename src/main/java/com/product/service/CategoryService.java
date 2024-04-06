package com.product.service;

import java.util.List;

import com.product.model.Category;



public interface CategoryService {
	public Category saveCategory(Category category);
	 public List<Category>getAllCategory();
	 public Category getCategoryById(String id);
	 public String deleteCategory(String id);
	 public Category updateCategory(Category c,String id);
	 public long countCategories();
	
	 

	
	
	
}
