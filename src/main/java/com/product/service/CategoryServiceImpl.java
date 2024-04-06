package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.model.Product;
import com.product.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public String deleteCategory(String id) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.findById(id).get();
		if(category!=null) {
			categoryRepository.delete(category);
			return "Category Deleted Successfully";
		}
		return "Something wrong on server";

	}

	@Override
	public Category updateCategory(Category c, String id) {
		// TODO Auto-generated method stub

		Category oldcategory=categoryRepository.findById(id).get();
		oldcategory.setCategoryName(c.getCategoryName());
		oldcategory.setBrandName(c.getBrandName());
		
		
		return categoryRepository.save(oldcategory);
	}

	@Override
	public long countCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.count();
	}

}
