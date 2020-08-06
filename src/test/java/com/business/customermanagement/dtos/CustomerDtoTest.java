package com.business.customermanagement.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.business.customermanagement.entities.Address;

public class CustomerDtoTest {
	
	CustomerDto customerDto;
	
	@BeforeEach
	public void setUp() {
		customerDto = new CustomerDto();
	}
	
	@Test
	public void testGetId() {
		UUID id = UUID.randomUUID();
		customerDto.setCustomerId(id);
        assertThat(id).isEqualTo(customerDto.getCustomerId());
	}
	
	@Test
	public void testGetFirstName() {
		String firstName = "Arya";
		customerDto.setFirstName(firstName);
		assertThat(firstName).isEqualTo(customerDto.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String lastName = "Stark";
		customerDto.setLastName(lastName);
		assertThat(lastName).isEqualTo(customerDto.getLastName());
	}
	@Test
	public void testGetAge() {
		int age = 30;
		customerDto.setAge(age);
        assertThat(age).isEqualTo(customerDto.getAge());
	}
	@Test
	public void testGetAddress() {
		Address address = new Address();
		address.setCity("Amsterdam");
		customerDto.setCurrentAddress(address);
		assertThat("Amsterdam").isEqualTo(customerDto.getCurrentAddress().getCity());
	}
}
