package com.business.customermanagement.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;

public class CustomerConverterTest {

	@InjectMocks
	private CustomerConverter customerConverter;

	private Customer customer;
	private CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customer = new Customer();
		customer.setFirstName("Arya");
		customer.setLastName("Stark");
		customerDto = new CustomerDto();
		customerDto.setFirstName("John");
		customerDto.setLastName("Snow");
	}

	@Test
	public void testEntityToDto() {
        assertThat(customerConverter.entityToDto(customer).getFirstName()).isEqualTo("Arya");
	}

	@Test
	public void testEntityToDtoForList() {
       List<Customer> customers = new ArrayList<>();
       customers.add(customer);
       assertThat(customerConverter.entityToDto(customers).size()).isEqualTo(1);
	}
	
	@Test
	public void testEntityToDtoForEmptyList() {
       List<Customer> customers = new ArrayList<>();
       Throwable thrown = catchThrowable(() -> {
    	   customerConverter.entityToDto(customers);
    	});
       assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	public void testDtoToEntity() {
		assertThat(customerConverter.dtoToEntity(customerDto).getFirstName()).isEqualTo("John");
	}

	@Test
	public void testDtoToEntityForList() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
	    assertThat(customerConverter.dtoToEntity(customerDtos).size()).isEqualTo(1);
		
	}

}
