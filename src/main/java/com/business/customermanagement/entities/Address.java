package com.business.customermanagement.entities;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Represents Address entity.
 */
@Data
@Embeddable
public class Address {
	
	private String houseNumber;
	
	private String street;
	
	private String city;
	
	private String province;
	
	private String country;
	
	private String pincode;
	
	
}
