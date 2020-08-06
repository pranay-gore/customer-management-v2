package com.business.customermanagement.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.customermanagement.entities.Customer;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

	/**
	 * Find by first name ignore case and last name ignore case.
	 *
	 * @param string represents firstName
	 * @return the list
	 */
	List<Customer> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

	/**
	 * Finds customers based on their first name 
	 *
	 * @param string represents firstName
	 * @return the list
	 */
	List<Customer> findByFirstNameIgnoreCase(String firstName);

	/**
	 * Finds customers based on their last name 
	 *
	 * @param string represents lastName
	 * @return the list
	 */
	List<Customer> findByLastNameIgnoreCase(String lastName);

}
