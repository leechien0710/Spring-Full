package com.example.demo.Api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CustomerDto;
import com.example.demo.Implement.CustomerImp;
import com.example.demo.Models.UserRole;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerApi {
	@Autowired private CustomerImp customerImp;
	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable long id) {
		return customerImp.getCustomerById(id);
	}
	@GetMapping("/role/{role}")
	public ResponseEntity<Object> CountByRole(@PathVariable UserRole role){
		return new ResponseEntity<>(customerImp.countByRole(role),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> SaveCustomerDto(@Valid @RequestBody CustomerDto customerDto,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			String errors= "";
			for(FieldError fieldError : bindingResult.getFieldErrors()) {
				errors = errors+fieldError.getDefaultMessage()+"\n";
			}
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		}
		customerImp.saveCustomer(customerDto);
		return new ResponseEntity<>("Customer is saved successful",HttpStatus.CREATED);
	}
	@PostMapping("/create")
	public ResponseEntity<Object> SaveCustomerDtoForm(@RequestParam long id,
			@RequestParam String email,@RequestParam String password) {
		customerImp.saveCustomer(new CustomerDto(id,email,password));
		return ResponseEntity.ok("Customer is saved successful");
	}
}
