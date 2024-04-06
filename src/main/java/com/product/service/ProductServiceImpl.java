package com.product.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.product.exception.ResourceNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
   
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {

		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	public Product getProductById(String id) {
		
		Product p=productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", id));
		return productRepo.findById(id).get();
	}

	public String deleteProduct(String id) {
		Product product=productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", id));
	if(product!=null) {
		productRepo.delete(product);
		return "Product Deleted Successfully";
	}
	return "Something wrong on server";
		
	}

	public Product updateProduct(Product p, String id) {
		//Product oldproduct=productRepo.findById(id).get();
		Product oldproduct=productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", id));
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		
		return productRepo.save(oldproduct);
		
	}
		
		//********************IMAGE UPLOAD*******************

    /*public void uploadImage( MultipartFile image) {
        try {
            // Save the image to a directory
            File directory = new File("C:\\Users\\sgorkhe\\Documents\\productmanagement\\Product_Management_Backend\\src\\main\\resources\\static\\image");
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            // Construct the file path where the image will be saved
            String filePath = directory.getAbsolutePath() + File.separator + image.getOriginalFilename();
            File convertedFile = new File(filePath);
            convertedFile.createNewFile();

            // Write the image bytes to the file
            try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
                fos.write(image.getBytes());
            }

            // Retrieve the product from the database using the productId
            Product product =new Product();

            // Set the image filename for the product
            product.setImageFilename(image.getOriginalFilename());

            // Save the product with the updated image filename
            productRepo.save(product);
        } catch (IOException e) {
            // Handle file IO exception
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // Handle product not found exception
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }*/
	
	  @Transactional(rollbackFor = Exception.class)
	    public void uploadImage(MultipartFile image) throws IOException {
	        // Save the image to a directory
	        File directory = new File("C:\\Users\\sgorkhe\\Desktop\\product\\Product_Management_Backend\\src\\main\\resources\\static\\image");
	        if (!directory.exists() && !directory.mkdirs()) {
	            throw new IOException("Failed to create directory for image upload.");
	        }

	        // Construct the file path where the image will be saved
	        String filePath = directory.getAbsolutePath() + File.separator + image.getOriginalFilename();
	        File convertedFile = new File(filePath);

	        // Write the image bytes to the file
	        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
	            fos.write(image.getBytes());
	        }

	        // Save the product with the updated image filename
	        Product product = new Product();
	        product.setImageFilename(image.getOriginalFilename());
	        productRepo.save(product);
	    }

	@Override
	public List<Product> getProductByCategoryId(int categoryId) {
	
		return productRepo.getProductByCategoryId(categoryId) ;
	}
	  
//****************************************************************//
		
		
	
  
}
