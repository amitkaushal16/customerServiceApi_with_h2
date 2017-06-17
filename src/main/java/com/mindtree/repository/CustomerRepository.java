package com.mindtree.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	public Optional<List<Customer>> findByLastName(String lastName); 

}
