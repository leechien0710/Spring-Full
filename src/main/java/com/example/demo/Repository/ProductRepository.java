package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.Product;
import com.example.demo.Models.UserRole;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
