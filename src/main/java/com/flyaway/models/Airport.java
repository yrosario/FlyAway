package com.flyaway.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport {
	
	@Id
	@GeneratedValue
	private int airportId;
	private String name;
	private String country;
	private String state;
	private String city;
	
	public Airport() {
	}
	
	//foreign key to departure airport
	/*@OneToMany(mappedBy="airport",
		       cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			              CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Flight> deparAiports;
	
	//foreign key to arrival airport
	@OneToMany(mappedBy="airport",
		       cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			              CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Flight> arrivalAiports;*/

	public Airport(String name, String country, String state, String city) {
		super();
		this.name = name;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public int getAirportId() {
		return airportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
