package com.example.Backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Optional;

import com.example.Backend.service.ProductService;
import com.example.Backend.model.Product;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private ProductService service;
    public ProductController(ProductService service){
        this.service=service;
    }

    @GetMapping("/")
    public String hello(){
        return "HelloWorld";
    }
    
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<List<Product>>(service.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id){
        Product product = service.getProductById(id);
        byte[] image=product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(image);
        
    }


    @PostMapping(value = "/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile){
        try{
            System.out.println(product);
            Product product1=service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            

        }

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile){
        try{Product prod=service.updateProduct(id,product,imageFile);
        if (prod!=null) {
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }}catch(Exception e){
            System.err.println(e);
            return new ResponseEntity<>("Failed to update",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product =service.getProductById(id);
        if (product!=null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
            System.out.println("searching with"+keyword);
            List<Product> products=service.searchProducts(keyword);
            return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
