package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.models.Airline;


public class AirlineManager {
	
	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public AirlineManager() {
		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.models.Airline.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
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
