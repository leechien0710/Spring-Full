package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Customer;
import com.example.demo.Models.UserRole;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("SELECT COUNT(u) FROM Customer u WHERE u.role = :role")
    long countByRole(@Param("role") UserRole role);
	@Query("SELECT c FROM Customer c where c.role = :role")
	List<Customer> ListByRole(@Param("role") UserRole role);
}
