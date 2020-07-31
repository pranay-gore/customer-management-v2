package com.business.customermanagement.dtos;

import lombok.Data;

/**
 * Represents an Address dto.
 */
@Data
public class AddressDto {

	private String houseNumber;

	private String street;

	private String city;

	private String province;

	private String country;

	private String pincode;

}