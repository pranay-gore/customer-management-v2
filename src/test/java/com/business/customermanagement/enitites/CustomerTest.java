package com.business.customermanagement.enitites;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.business.customermanagement.entities.Address;
import com.business.customermanagement.entities.Customer;

public class CustomerTest {
	
	Customer customer;

	@BeforeEach
	public void setUp() {
		customer = new Customer();
	}
	
	@Test
	public void testGetId() {
		UUID id = UUID.randomUUID();
		customer.setCustomerId(id);
        assertThat(id).isEqualTo(customer.getCustomerId());
	}
	
	@Test
	public void testGetFirstName() {
		String firstName = "Arya";
		customer.setFirstName(firstName);
		assertThat(firstName).isEqualTo(customer.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String lastName = "Stark";
		customer.setLastName(lastName);
		assertThat(lastName).isEqualTo(customer.getLastName());
	}
	@Test
	public void testGetAge() {
		int age = 30;
		customer.setAge(age);
        assertThat(age).isEqualTo(customer.getAge());
	}
	@Test
	public void testGetAddress() {
		Address address = new Address();
		address.setCity("Amsterdam");
		customer.setAddress(address);
		assertThat("Amsterdam").isEqualTo(customer.getAddress().getCity());
	}
	@Test
	public void testGetCreatedTime() {
		LocalDateTime creationTime = LocalDateTime.of(2020, 12, 12, 12, 12);
		customer.setCreatedTime(creationTime);
		assertThat(creationTime).isEqualTo(customer.getCreatedTime());
	}
	@Test
	public void testGetUpdatedTime() {
		LocalDateTime updatedTime = LocalDateTime.of(2020, 12, 12, 14, 14);
		customer.setUpdatedTime(updatedTime);
		assertThat(updatedTime).isEqualTo(customer.getUpdatedTime());
	}
}
