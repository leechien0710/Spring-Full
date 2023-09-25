package com.example.demo.DTO;

import com.example.demo.Models.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
	private long id;
	@Email(message = "Email not valid")
	private String email;
	@NotBlank(message = "Password must Requied")
	private String password;
	public static CustomerDto toDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto(customer.getIdCustomer(),
				customer.getEmail(),customer.getPassword());
		return customerDto;
	}
	public CustomerDto() {}

}
