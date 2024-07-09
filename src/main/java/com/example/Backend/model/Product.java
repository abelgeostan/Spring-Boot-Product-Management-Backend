package com.example.Backend.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    @JsonProperty("description")
    private String desc;
    
    private String brand;
    
    private BigDecimal price;
    
    private String category;
    
    @JsonProperty("releaseDate")
    private Date date;
    
    @JsonProperty("productAvailable")
    private Boolean available;
    
    @JsonProperty("stockQuantity")
    private int quantity;

    private String imageName;
    private String imageType;
    
    @Column(columnDefinition="BLOB")
    private byte[] imageData;
}
