package com.example.demo.Service;

import java.util.List;


import com.example.demo.Models.Product;

public interface ProductService {
	List<Product> getAllProduct();
	Product getProductById(long id);
	void saveProduct(Product product);
	void deleteProductById(long id);
}
