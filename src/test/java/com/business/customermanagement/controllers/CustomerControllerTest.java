package com.business.customermanagement.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.impl.CustomerServiceImpl;

public class CustomerControllerTest {

	@Mock
	private CustomerServiceImpl customerService;

	@InjectMocks
	private CustomerController controller;

	CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customerDto = new CustomerDto();
		customerDto.setFirstName("Arya");
		customerDto.setLastName("Stark");
	}

	@Test
	public void TestAddCustomer() {
		when(customerService.addCustomer(customerDto)).thenReturn(customerDto);
		assertThat(controller.addCustomer(customerDto).getFirstName()).isEqualTo("Arya");
	}

	@Test
	public void TestUpdateCustomer() {
		when(customerService.updateCustomer(1, customerDto)).thenReturn(customerDto);
		assertThat(controller.updateCustomer(1, customerDto).getFirstName()).isEqualTo("Arya");
	}

	@Test
	public void TestGetCustomerById() {
		when(customerService.getCustomerById(1)).thenReturn(customerDto);
		assertThat(controller.getCustomerById(1).getFirstName()).isEqualTo("Arya");
	}

	@Test
	public void TestGetCustomersWithNoParam() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getAllCustomers()).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.empty(), Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithFirstName() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerName(Optional.of("Arya"), Optional.empty())).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.of("Arya"), Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithLastName() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerName(Optional.empty(), Optional.of("Stark"))).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.empty(), Optional.of("Stark")).size()).isEqualTo(1);
	}

}
