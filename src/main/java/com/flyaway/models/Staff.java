package com.flyaway.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue
	private int employeeId;
	private String fname;
	private String lname;
	private String phoneNo;
	private String address;
	private String email;
	
	public Staff() {
		
	}

	public Staff(String fname, String lname, String phoneNo, String address, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Staff [employeeId=" + employeeId + ", fname=" + fname + ", lname=" + lname + ", phoneNo=" + phoneNo
				+ ", address=" + address + "]";
	}
	
	
}
