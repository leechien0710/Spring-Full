package com.example.demo.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CustomerDto;
import com.example.demo.Models.Customer;
import com.example.demo.Models.UserRole;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;
@Service
public class CustomerImp implements CustomerService{
	@Autowired CustomerRepository customerRepository;
	@Override
	public CustomerDto getCustomerById(long id) {
		// TODO Auto-generated method stub
		return CustomerDto.toDto(customerRepository.getById(id));
	}
	@Override
	public void saveCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		customerRepository.save(new Customer(customerDto));
	}
	@Override
	public long countByRole(UserRole role) {
		// TODO Auto-generated method stub
		return customerRepository.countByRole(role);
	}
}
