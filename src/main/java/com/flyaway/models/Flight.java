package com.flyaway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int flightId;
	private int customerId;
	private int staffId;
	private int airportDepatureId;
	private int airportArrId;
	private int availableSeats;
	private int seatNo;
	private String departureTime;
	private String arrivalTime;
	
	
	public Flight() {
	}
	
	public Flight(int airportDepatureId, int airportArrId, int availableSeats, String departureTime,
			String arrivalTime) {

		this.airportDepatureId = airportDepatureId;
		this.airportArrId = airportArrId;
		this.availableSeats = availableSeats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		customerId = 0;
		staffId = 0;
		seatNo = 0;
	}

	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getAirportDepatureId() {
		return airportDepatureId;
	}
	public void setAirportDepatureId(int airportDepatureId) {
		this.airportDepatureId = airportDepatureId;
	}
	public int getAirportArrId() {
		return airportArrId;
	}
	public void setAirportArrId(int airportArrId) {
		this.airportArrId = airportArrId;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	
	
	
}
