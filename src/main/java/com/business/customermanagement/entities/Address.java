package com.business.customermanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Represents Address entity.
 */
@Entity
@Data
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "House number is mandatory")
	@Column(name = "house_number")
	private String houseNumber;
	
	@NotBlank(message = "Street name is mandatory")
	@Column(name = "street")
	private String street;
	
	@NotBlank(message = "City name is mandatory")
	@Column(name = "city")
	private String city;
	
	@NotBlank(message = "Province name is mandatory")
	@Column(name = "province")
	private String province;
	
	@NotBlank(message = "Country is mandatory")
	@Column(name = "country")
	private String country;
	
	@NotBlank(message = "Pincode is mandatory")
	@Column(name = "pincode")
	private String pincode;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private Customer customer;
	
}
