package com.flyaway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airline {

	@Id
	@GeneratedValue
	private int airlineId;
	private String name;
	private int flightNo;
	
	public Airline() {
	}

	public Airline(String name, int flightNo) {
		super();
		this.name = name;
		this.flightNo = flightNo;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
	
}
