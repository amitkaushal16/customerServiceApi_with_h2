package com.mindtree.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.Customer;
import com.mindtree.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired	
	private MessageSource messageSource;

	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getCustomers(Pageable page, @RequestParam("lastName") Optional<String> lastName) {
		if (lastName.isPresent()) {
			return customerRepo.findByLastName(lastName.get()).get();
		}
		return customerRepo.findAll(page).getContent();
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("id") Integer id) {
		Customer customer = customerRepo.findOne(id);
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.bad.customer.id", null, locale);
		if (customer == null) {
			throw new ServiceException(404, errorMessage + id, null);
		}
		return customer;
	}

	  @Transactional
	@RequestMapping(value = "/customers", method = RequestMethod.POST,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void addCustomers(@RequestBody Customer customer) {
		customerRepo.save(customer);
	}

	@RequestMapping(value = "/customers/{Id}", method = RequestMethod.PUT,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void updateCustomers(@RequestBody Customer customer,@PathVariable("Id") Integer id) {
		customer.setId(id);
		customerRepo.save(customer);
	}

	@RequestMapping(value = "/customers/{Id}", method = RequestMethod.DELETE,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void deleteCustomers(@PathVariable("Id") Integer id) {
		customerRepo.delete(id);
	}

}
