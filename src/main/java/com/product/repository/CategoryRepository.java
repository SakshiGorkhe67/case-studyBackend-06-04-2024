package com.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Category;
@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
	List<Category> findByCategoryNameIn(List<String>categoryName);
	List<Category> findByBrandNameIn(List<String> brandName);
}
