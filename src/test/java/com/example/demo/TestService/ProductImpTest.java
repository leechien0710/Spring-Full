package com.example.demo.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Implement.ProductImp;
import com.example.demo.Models.Product;
import com.example.demo.Repository.ProductRepository;
public class ProductImpTest {
	@Mock private ProductRepository productRepository;
	@InjectMocks private ProductImp productImp;
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        List<Product> initialProductList = new ArrayList<>();
        initialProductList.add(new Product(1L, "Product 1", 10));
        initialProductList.add(new Product(2L, "Product 2", 20));
        when(productRepository.findAll()).thenReturn(initialProductList);
    }
	@Test
    public void testGetAllProducts() {
        List<Product> result = productImp.getAllProduct();
        verify(productRepository,times(1)).findAll();
        assertEquals(2, result.size());
    }
//	@Test
//	public void testDeleteProductById() {
//	    // Tạo một sản phẩm giả lập để kiểm tra
//	    Product productToDelete = new Product(1L, "Product 1", 10);
//
//	    // Giả lập phương thức findById của Repository để trả về sản phẩm cần xóa
//	    when(productRepository.findById(1L)).thenReturn(Optional.of(productToDelete));
//
//	    // Gọi phương thức deleteProductById
//	    productImp.deleteProductById(1);
//
//	    // Kiểm tra xem phương thức deleteById đã được gọi với đúng đối số 1L
//	    verify(productRepository, times(1)).deleteById(1L);
//
//	    // Kiểm tra xem danh sách sản phẩm sau khi xóa có trả về kích thước là 0
//	    List<Product> products = productRepository.findAll();
//	    assertEquals(0, products.size());
//	}
}
