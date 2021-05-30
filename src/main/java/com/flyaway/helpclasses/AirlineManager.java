package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Airline;
import com.flyaway.util.HibernateUtils;


public class AirlineManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public AirlineManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addAirline(String name, int flightNo) {
		
		try {
			Airline airline = new Airline(name, flightNo);
			session.save(airline);
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
