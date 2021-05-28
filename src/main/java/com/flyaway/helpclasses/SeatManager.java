package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.models.Seat;

public class SeatManager {
	
	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public SeatManager() {
		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.models.Seat.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean setSeat(int seatNo, int flightNo, float price) {
		try {
			Seat seat = new Seat(seatNo, flightNo, price);
			session.save(seat);
			transaction.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
	}
	
}
