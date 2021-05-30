package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Airport;
import com.flyaway.util.HibernateUtils;

public class AirportManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public AirportManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addAirport(String name, String country, String state, String city) {
		
		try {
			Airport airport = new Airport(name, country, state, city);
			session.save(airport);
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
