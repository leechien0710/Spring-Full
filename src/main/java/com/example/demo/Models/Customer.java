package com.example.demo.Models;


import com.example.demo.DTO.CustomerDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Table(name = "Customer")
@Entity
@Data
public class Customer {
	@Id
	private long idCustomer;
	private String nameCustomer;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	public Customer( CustomerDto customerDto) {
		idCustomer = customerDto.getId();
		email = customerDto.getEmail();
		password =customerDto.getPassword();
	}
	public Customer() {}
}

