package com.flyaway.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passager {
	@Id
	@GeneratedValue
	private int passagerId;
	private String fname;
	private String lname;
	private String birthday;
	private String address;
	private String phoneNumber;
	private String password;
	private String email;
	
	@OneToMany(mappedBy="passager",
		       cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			              CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Purchased> purchases;
	
	public Passager() {
		
	}
	
	
	public Passager(String fname, String lname, String birthday, String address,
			String phoneNumber, String password, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.birthday = birthday;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
	    this.email = email;		
	}



	public int getPassagerId() {
		return passagerId;
	}

	public void setPassagerId(int passagerId) {
		this.passagerId = passagerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Purchased> getPurchases() {
		return purchases;
	}


	public void setPurchases(List<Purchased> purchases) {
		this.purchases = purchases;
	}

	public void add(Purchased tempCourse) {
		
		if(purchases == null) {
			purchases = new ArrayList<>();
		}
		
		purchases.add(tempCourse);
		
		tempCourse.setPassager(this);
	}

	@Override
	public String toString() {
		return "Passager [passagerId=" + passagerId + ", fname=" + fname + ", lname=" + lname
				+ ", birthday=" + birthday + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

	
	
}
