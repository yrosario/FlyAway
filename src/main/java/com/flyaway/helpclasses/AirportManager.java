package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.models.Airport;

public class AirportManager {
	
	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public AirportManager() {
		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.models.Airport.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
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
