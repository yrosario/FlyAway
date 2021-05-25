package com.flyaway.flightmanager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.flyaway.flight.Flight;

public class FlightManager {
	
	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public FlightManager() {
		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.flight.Flight.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addFlight(int airportDepatureId, int airportArrId, int availableSeats, String departureTime, String ArrivalTime) {
		try {
			Flight flight = new Flight(airportDepatureId, airportArrId, availableSeats, departureTime, ArrivalTime);
			session.save(flight);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e) {
			System.out.println("Failed to add flight " + e);
			session.close();
			return false;
		}
		
	}
	

}
