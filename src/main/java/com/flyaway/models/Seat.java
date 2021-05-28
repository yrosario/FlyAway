package com.flyaway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue
	private int seatNo;
	private int flightNo;
	private float price;
	
	public Seat() {
	}

	public Seat(int seatNo, int flightNo, float price) {
		super();
		this.seatNo = seatNo;
		this.flightNo = flightNo;
		this.price = price;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", flightNo=" + flightNo + ", price=" + price + "]";
	}
	
	
	
}
