package com.business.customermanagement.converters;

import org.springframework.stereotype.Component;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.entities.Address;
@Component
public class AddressConverter {
	
	public Address DtoToEntity(AddressDto addressDto) {
		Address address = new Address();
		address.setHouseNumber(addressDto.getHouseNumber());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setProvince(addressDto.getProvince());
		address.setStreet(addressDto.getStreet());
		return address;
	}
}
