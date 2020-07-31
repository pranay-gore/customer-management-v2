package com.business.customermanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@Override
	public CustomerDto updateAddress(Integer id, AddressDto addressDto) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND));
		
		int addressId = customer.getAddress().getId();
		customer.setAddress(addressConverter.DtoToEntity(addressDto));
		customer.getAddress().setId(addressId);
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

}
