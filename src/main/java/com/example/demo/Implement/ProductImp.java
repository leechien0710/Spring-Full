package com.example.demo.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;

@Service
public class ProductImp implements ProductService{
	@Autowired private ProductRepository productRepository;
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		
		return productRepository.findById(id).get();
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProductById(long id) {
		productRepository.deleteById(id);
		
	}
	
}
