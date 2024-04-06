package com.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("product_data")

public class Product {
    @Id
    private String id;
    private String productName;
    private String description;
    private double price;
    private String status;
    //private String imageName;
    private String imageFilename;
    private int categoryId;
    
	
	
}