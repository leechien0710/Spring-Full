package com.example.demo.Api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Implement.ProductImp;
import com.example.demo.Models.Product;
import com.example.demo.Service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/product")
public class ProductApi {
    private static final Logger logger = LoggerFactory.getLogger(ProductApi.class);
	@Autowired ProductImp productImp;
	@GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productImp.getAllProduct();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            // Xử lý lỗi nếu cần
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server error");
        }
    }
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		logger.info("Getting product by id: {}",id);
	    Product product = productImp.getProductById(id);
	    if (product != null) {
	    	logger.info("product found with id: {}",id);
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    } else {
	    	logger.warn("product not found with id: {}",id);
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> DeleteById(@PathVariable long id){
		try {
			productImp.deleteProductById(id);
			return new ResponseEntity<>("Delete successful",HttpStatus.NO_CONTENT);
			
		}catch (EntityNotFoundException e) {
			// TODO: handle exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
		}catch (Exception e) {
            // Xử lý các lỗi khác nếu cần
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
	}
}
