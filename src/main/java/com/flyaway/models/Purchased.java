package com.flyaway.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Purchased {

	@Id
	@GeneratedValue
	private int purchasedId;
	
	private int customerId;
	private int flightId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						  CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="passagerId")
	private Passager passager;
	
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
	
	

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	@Override
	public String toString() {
		return "Purchased [purchasedId=" + purchasedId + ", customerId=" + customerId + ", flightId=" + flightId + "]";
	}
	
	
	
}
