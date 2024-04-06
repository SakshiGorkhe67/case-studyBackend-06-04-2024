package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Category;
import com.product.service.CategoryServiceImpl;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CategoryController {
	@Autowired
	 CategoryServiceImpl categoryService;
	
	
	 @PostMapping("/saveCategory")
	  public ResponseEntity<Category>saveCategory(@RequestBody Category category){
		return new ResponseEntity<Category>( categoryService.saveCategory(category),HttpStatus.CREATED);
	  } 
	  
	 
	  @GetMapping("/getAllCategory")
	  public ResponseEntity<List<Category>>getAllCategory(){
		  return new ResponseEntity<List<Category>>(categoryService.getAllCategory(),HttpStatus.OK);
	  }
	  

	  @GetMapping("/getCategoryById/{id}")
	  public ResponseEntity<Category>getCategoryById(@PathVariable String id){
		  return new ResponseEntity<Category>(categoryService.getCategoryById(id),HttpStatus.OK);
	  }
	 

	  @DeleteMapping("/deleteCategory/{id}")
	  public ResponseEntity<String>deleteCategory(@PathVariable String id){
		  return new ResponseEntity<String>(categoryService.deleteCategory(id),HttpStatus.OK);
		  }
	  
	  @PutMapping("/updateCategory/{id}")
	  public ResponseEntity<Category>updateCategory(@RequestBody Category category,@PathVariable String id){
		  return new ResponseEntity<Category>( categoryService.saveCategory(category),HttpStatus.OK);
	  }
	
	
}
