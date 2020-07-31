package com.business.customermanagement.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Represents a Customer entity.
 */
@Entity
@Data
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Firstname is mandatory")
	@Column(name = "firstname")
	private String firstName;

	@NotBlank(message = "Lastname is mandatory")
	@Column(name = "lastname")
	private String lastName;

	@Positive(message = "Age should be greater than 0")
	@Column(name = "age")
	private int age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"customer", "id"})
	private Address address;

	@CreationTimestamp
	@Column(name = "creation_time")
	private LocalDateTime createdTime;

	@UpdateTimestamp
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

}
