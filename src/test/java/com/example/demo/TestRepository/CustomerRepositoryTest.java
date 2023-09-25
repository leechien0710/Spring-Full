package com.example.demo.TestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Models.Customer;
import com.example.demo.Models.UserRole;
import com.example.demo.Repository.CustomerRepository;

import jakarta.transaction.Transactional;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCountByRole() {
        // Tạo và lưu các đối tượng Customer với role cụ thể
        Customer customer1 = new Customer();
        customer1.setIdCustomer(1);
        customer1.setEmail("chien@gmail.com");
        customer1.setRole(UserRole.USER);
        customerRepository.save(customer1);
        Customer customer2 = new Customer();
        customer2.setIdCustomer(2);
        customer2.setRole(UserRole.ADMIN);
        customerRepository.save(customer2);
        Customer customer3 = new Customer();
        customer3.setIdCustomer(3);
        customer3.setRole(UserRole.USER);
        customerRepository.save(customer3);

        // Sử dụng hàm countByRole để đếm số lượng Customer với role UserRole.USER
        long countUser = customerRepository.countByRole(UserRole.USER);
        long countAdmin = customerRepository.countByRole(UserRole.ADMIN);
        List<Customer> customers = customerRepository.ListByRole(UserRole.USER);
        assertEquals(customers.size(), 2);
        assertEquals("chien@gmail.com", customers.get(0).getEmail());
        // Kiểm tra xem kết quả có đúng không
        assertEquals(2, countUser);
        assertEquals(1, countAdmin);
    }
    
}