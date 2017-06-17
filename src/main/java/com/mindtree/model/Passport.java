package com.mindtree.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passport {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String passportNumber;
	private String nationality;
	private String countryOfIssue;
	@JsonIgnore
	private LocalDate expDate;
	private String expiryDate;

	@Transient
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public String getExpiryDate() {
		if (expDate != null) {
			return expDate.format(formatter);
		}
		return "";
	}

	public void setExpiryDate(String expiryDate) {
		// this.expiryDate = expiryDate;
		this.expDate = LocalDate.parse(expiryDate, formatter);
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountryOfIssue() {
		return countryOfIssue;
	}

	public void setCountryOfIssue(String countryOfIssue) {
		this.countryOfIssue = countryOfIssue;
	}

}
