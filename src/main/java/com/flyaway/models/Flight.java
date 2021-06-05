package com.flyaway.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int flightId;
	private int staffId;
	private int airportDepatureId;
	private int airportArrId;
	private int availableSeats;
	private int seatNo;
	private Date departureTime;
	private Date arrivalTime;
	
	@OneToMany(mappedBy="flight",
		       cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			              CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Purchased> purchases;
	
	
	public Flight() {
	}
	
	public Flight(int airportDepatureId, int airportArrId, int availableSeats, Date departureTime,
			Date arrivalTime) {

		this.airportDepatureId = airportDepatureId;
		this.airportArrId = airportArrId;
		this.availableSeats = availableSeats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		staffId = 0;
		seatNo = 0;
	}

	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<Purchased> getPurchases() {
		return purchases;
	}

	public void setPurchases(Purchased tempPurchases) {
		
		if(purchases == null)
		{
			purchases = new ArrayList<>();
		}
		
		purchases.add(tempPurchases);
		tempPurchases.setFlight(this);
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", staffId=" + staffId + ", airportDepatureId=" + airportDepatureId
				+ ", airportArrId=" + airportArrId + ", availableSeats=" + availableSeats + ", seatNo=" + seatNo
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	
	
	
	
}
