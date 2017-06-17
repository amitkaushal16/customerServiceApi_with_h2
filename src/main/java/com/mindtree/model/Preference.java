package com.mindtree.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Preference {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String types;
	private String values;
	@ManyToOne()
	private Customer customer;

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String value) {
		this.values = value;
	}

}
