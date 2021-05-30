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
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						  CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="passagerId")
	private Passager passager;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			  CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="flightId")
    private Flight flight;
	
	public Purchased() {
	}

	public int getPurchasedId() {
		return purchasedId;
	}

	public void setPurchasedId(int purchasedId) {
		this.purchasedId = purchasedId;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Purchased [purchasedId=" + purchasedId +"]";
	}
	
}
