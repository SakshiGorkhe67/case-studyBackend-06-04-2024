package com.product.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.product.model.Product;
import com.product.service.CategoryService;
import com.product.service.ProductServiceImpl;
@CrossOrigin(origins="http://localhost:3000")
@RestController           //1ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
//<Product>
//@RequestBody Product product,
public class ProductController {
	//public final String UPLOAD_DIR="C:\\Users\\sgorkhe\\Documents\\productmanagement\\Product_Management_Backend\\src\\main\\resources\\static\\image";
	//*********Autowiring service class
  @Autowired
  private ProductServiceImpl productService;
  @Autowired CategoryService categoryService;
  
  //private FileUploadHelper fileUploadHelper;
  //for adding product

	 @PostMapping("/saveProduct")
	  public ResponseEntity<Product>saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>( productService.saveProduct(product),HttpStatus.CREATED);
	  } 
 /* public ResponseEntity<Product> saveProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file) {
      try {
          // Set the received data to the new Product object
          Product newProduct = new Product();
          newProduct.setProductName(product.getProductName());
          newProduct.setDescription(product.getDescription());
          newProduct.setPrice(product.getPrice());
          newProduct.setStatus(product.getStatus());
          
          // Save the new product
          productService.saveProduct(newProduct);
          
          // Check if the file is empty or not a PNG image
          if (file.isEmpty() || !file.getContentType().equals("image/png")) {
              // If file is empty or not PNG, return bad request
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newProduct);
          }

          // Attempt to upload the file
          boolean uploadStatus = fileUploadHelper.uploadFile(file);

          if (uploadStatus) {
              // If upload is successful, return the saved product with CREATED status
              return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
          } else {
              // If upload fails, return internal server error
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(newProduct);
          }
      } catch (Exception e) {
          e.printStackTrace();
          // Exception occurred, return internal server error with product data
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(product);
      }
  }*/

  
  
  
  
  
  
  
  
  
	/*@PostMapping("/saveImage/{productId}")
	public String productAddPost(@RequestParam("file")MultipartFile file,@PathVariable String productId) throws IOException{
	  
  
	String imageUUID;
	
	if(!file.isEmpty())
	{
		imageUUID=file.getOriginalFilename();
		
		Path fileNameAndPath=Paths.get(UPLOAD_DIR,imageUUID);
		Files.write(fileNameAndPath,file.getBytes());
	}
	
	

	
	
     return "product added successfully";
}
*/
	 //****************************UPLOADIMAGE*********************************************//
	 
	 
	 
	 
	 @PostMapping("/saveImage")
	 public ResponseEntity<String> uploadImage( @RequestParam("file") MultipartFile image) {
	     try {   
		 productService.uploadImage( image);
			}
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
	    }
	 
	 
	 
	 
	 
	 //**************************************************************************************//











  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  //for fetching all  the product
  @GetMapping("/getAllProducts")
  public ResponseEntity<List<Product>>getAllProducts(){
	  return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
  }
  
  //for fetching product by id
  @GetMapping("/getProductById/{id}")
  public ResponseEntity<Product>getProductById(@PathVariable String id){
	  return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
  }
  //for deleting product
  @DeleteMapping("/deleteProduct/{id}")
  public ResponseEntity<String>deleteProduct(@PathVariable String id){
	  return new ResponseEntity<String>(productService.deleteProduct(id),HttpStatus.OK);
	  }
  
  @PutMapping("/updateProduct/{id}")
  public ResponseEntity<Product>updateProduct(@RequestBody Product product,@PathVariable String id){
	  return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.OK);
  }
  
  
  @GetMapping("/category/{catId}")
  public ResponseEntity<List<Product>>getProductByCategoryId(@PathVariable int catId){
	  return new ResponseEntity<List<Product>>(productService.getProductByCategoryId(catId),HttpStatus.OK);
	  
  }
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  

