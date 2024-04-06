package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {

 public Product saveProduct(Product product);
 public List<Product>getAllProduct();
 public Product getProductById(String id);
 public String deleteProduct(String id);
 public Product updateProduct(Product product,String id);
public List<Product>getProductByCategoryId(int categoryId);
	
}
