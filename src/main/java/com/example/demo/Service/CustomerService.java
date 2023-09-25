package com.example.demo.Service;

import com.example.demo.DTO.CustomerDto;
import com.example.demo.Models.UserRole;

public interface CustomerService {
	public CustomerDto getCustomerById(long id);
	public void saveCustomer(CustomerDto customerDto);
	public long countByRole(UserRole role);
}
