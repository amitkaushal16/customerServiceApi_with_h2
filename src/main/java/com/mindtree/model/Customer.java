package com.mindtree.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String title;
	private String firstName;
	private String lastName;
	@Transient
	private String dateofBirth;
	@JsonIgnore
	private LocalDate dob;
	private String countryofResident;
	private String nationality;
	private String customerRelation;
	@JsonIgnore
	private String password;
	private String preferredLangauage;
	private String skywardsNumber;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Preference> preferences;

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	// @JoinColumn(name = "PASSPORT_ID")
	private Passport passport;

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Embedded
	private Address address;
	@Transient
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public String getDateofBirth() {
		if (dob != null) {
			return dob.format(formatter);
		}
		return "";
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
		this.dob = LocalDate.parse(dateofBirth, formatter);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer() {
	}

	public Customer(Integer id, String title, String firstName, String lastName, LocalDate dob, String countryofResident, String nationality, String customerRelation, String password,
			String preferredLangauage, String skywardsNumber) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryofResident = countryofResident;
		this.nationality = nationality;
		this.customerRelation = customerRelation;
		this.password = password;
		this.preferredLangauage = preferredLangauage;
		this.skywardsNumber = skywardsNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryofResident() {
		return countryofResident;
	}

	public void setCountryofResident(String countryofResident) {
		this.countryofResident = countryofResident;
	}

	public String getCustomerRelation() {
		return customerRelation;
	}

	public void setCustomerRelation(String customerRelation) {
		this.customerRelation = customerRelation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreferredLangauage() {
		return preferredLangauage;
	}

	public void setPreferredLangauage(String preferredLangauage) {
		this.preferredLangauage = preferredLangauage;
	}

	public String getSkywardsNumber() {
		return skywardsNumber;
	}

	public void setSkywardsNumber(String skywardsNumber) {
		this.skywardsNumber = skywardsNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
