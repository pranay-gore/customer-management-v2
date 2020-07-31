package com.business.customermanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
import com.business.customermanagement.repositories.CustomerRepository;

public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerConverter customerConverter;

	private Customer customer;
	private CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customerDto = new CustomerDto();
		customerDto.setFirstName("Arya");
		customerDto.setLastName("Stark");
		customer = new Customer();
		customer.setFirstName("Arya");
		customer.setLastName("Stark");
	}

	@Test
	public void testAddCustomer() {
		when(customerConverter.dtoToEntity(customerDto)).thenReturn(customer);
		when(customerRepository.save(customer)).thenReturn(customer);
		when(customerConverter.entityToDto(customer)).thenReturn(customerDto);

		CustomerDto addedCustomer = customerService.addCustomer(customerDto);
		assertThat(addedCustomer.getFirstName()).isEqualTo(customer.getFirstName());
	}

	@Test
	public void testUpdateCustomerForException() {
		Optional<Customer> optinalCustomer = Optional.empty();
		when(customerRepository.findById(1)).thenReturn(optinalCustomer);

		Throwable thrown = catchThrowable(() -> {
			customerService.updateCustomer(1, customerDto);
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	public void testUpdateCustomer() {
		Optional<Customer> optinalCustomer = Optional.of(customer);
		when(customerRepository.findById(1)).thenReturn(optinalCustomer);
		when(customerRepository.save(customer)).thenReturn(customer);
		when(customerConverter.entityToDto(customer)).thenReturn(customerDto);

		assertThat(customerService.updateCustomer(1, customerDto).getFirstName()).isEqualTo(customer.getFirstName());
	}

	@Test
	public void testGetAllCustomersForException() {
		List<Customer> customers = new ArrayList<>();
		when(customerRepository.findAll()).thenReturn(customers);
		Throwable thrown = catchThrowable(() -> {
			customerService.getAllCustomers();
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	public void testGetAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findAll()).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);

		assertThat(customerService.getAllCustomers().size()).isEqualTo(1);
	}
	
	@Test
	public void testGetCustomerByIdForException() {
		Optional<Customer> optinalCustomer = Optional.empty();
		when(customerRepository.findById(1)).thenReturn(optinalCustomer);

		Throwable thrown = catchThrowable(() -> {
			customerService.getCustomerById(1);
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}
	
	@Test
	public void testGetCustomerById() {
		Optional<Customer> optinalCustomer = Optional.of(customer);
		when(customerRepository.findById(1)).thenReturn(optinalCustomer);
		when(customerConverter.entityToDto(customer)).thenReturn(customerDto);
        assertThat(customerService.getCustomerById(1).getFirstName()).isEqualTo(customer.getFirstName());
	}
	
	@Test
	public void testGetCustomerByNameWithFirstName() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findByFirstNameIgnoreCase("Arya")).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);
		assertThat(customerService.getByCustomerName(Optional.of("Arya"), Optional.empty()).size()).isEqualTo(1);
	}
	
	@Test
	public void testGetCustomerByNameWithLastName() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findByLastNameIgnoreCase("Stark")).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);
		assertThat(customerService.getByCustomerName(Optional.empty(), Optional.of("Stark")).size()).isEqualTo(1);
	}
	
	@Test
	public void testGetCustomerByNameWithFirstAndLastName() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Arya","Stark")).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);
		assertThat(customerService.getByCustomerName(Optional.of("Arya"), Optional.of("Stark")).size()).isEqualTo(1);
	}
	
	@Test
	public void testGetCustomerByNameForException() {
		List<Customer> customers = new ArrayList<>();
		when(customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Arya","Stark")).thenReturn(customers);
		Throwable thrown = catchThrowable(() -> {
			customerService.getByCustomerName(Optional.of("Arya"), Optional.of("Stark"));
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}
}
