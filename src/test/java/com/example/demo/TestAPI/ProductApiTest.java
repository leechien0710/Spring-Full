package com.example.demo.TestAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Api.ProductApi;
import com.example.demo.Implement.ProductImp;
import com.example.demo.Models.Product;

public class ProductApiTest {
	@Mock private ProductImp productImp;
	@InjectMocks private ProductApi productApi;
	List<Product> fakeProducts = new ArrayList<>();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		Product product1 = new Product(1L,"Product1",20);
		Product product2 = new Product(2L,"Product2",30);
		fakeProducts.add(product1);
		fakeProducts.add(product2);
		when(productImp.getAllProduct()).thenReturn(fakeProducts);
	}
	@Test
	public void GetAllProductTestApi() {
		ResponseEntity<List<Product>> entity = productApi.getAllProducts();
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
		assertEquals(entity.getBody(), fakeProducts );
	}
//	@Test
//	public void GetAllProductHandleException() {
//		
//	}
	@Test
	public void DeleteByIdApi() {
		
	}
}
