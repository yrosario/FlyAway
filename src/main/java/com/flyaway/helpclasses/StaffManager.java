package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Staff;
import com.flyaway.util.HibernateUtils;

public class StaffManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public StaffManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addStaff(String fname, String lname, String phone, String address, String email) {
		
		try {
			Staff staff = new Staff(fname, lname, phone, address, email);
			session.save(staff);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

}
