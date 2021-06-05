package com.flyaway.helpclasses;


import java.text.Format;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Flight;
import com.flyaway.util.HibernateUtils;

public class FlightManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public FlightManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addFlight(int airportDepatureId, int airportArrId, int availableSeats, String departureTime, String ArrivalTime) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Flight flight = 
					new Flight(airportDepatureId, airportArrId, availableSeats, format.parse(departureTime) , format.parse(ArrivalTime));
			session.save(flight);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to add flight " + e);
			session.close();
			return false;
		}
		
	}
	

}
