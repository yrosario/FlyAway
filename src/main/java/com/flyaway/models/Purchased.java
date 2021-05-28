package com.flyaway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Purchased {

	@Id
	@GeneratedValue
	private int purchasedId;
	private int customerId;
	private int flightId;
	
	public Purchased() {
	}

	public Purchased(int customerId, int flightId) {
		super();
		this.customerId = customerId;
		this.flightId = flightId;
	}

	public int getPurchasedId() {
		return purchasedId;
	}

	public void setPurchasedId(int purchasedId) {
		this.purchasedId = purchasedId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Purchased [purchasedId=" + purchasedId + ", customerId=" + customerId + ", flightId=" + flightId + "]";
	}
	
	
	
}
