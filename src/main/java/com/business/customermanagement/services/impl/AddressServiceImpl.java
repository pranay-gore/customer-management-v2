package com.business.customermanagement.services.impl;

import org.springframework.stereotype.Service;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.converters.AddressConverter;
import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
import com.business.customermanagement.repositories.CustomerRepository;
import com.business.customermanagement.services.AddressService;
@Service
public class AddressServiceImpl implements AddressService{

	private CustomerRepository customerRepo;
	
	private CustomerConverter customerConverter;
	
	private AddressConverter addressConverter;
	
	public AddressServiceImpl(CustomerRepository customerRepo, CustomerConverter customerConverter,
			AddressConverter addressConverter) {
		this.customerRepo = customerRepo;
		this.customerConverter = customerConverter;
		this.addressConverter = addressConverter;
	}

	@Override
	public CustomerDto updateAddress(Integer id, AddressDto addressDto) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND));
		customer.setAddress(addressConverter.DtoToEntity(addressDto));
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

}
