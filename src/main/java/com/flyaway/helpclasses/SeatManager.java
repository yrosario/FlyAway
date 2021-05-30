package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Seat;
import com.flyaway.util.HibernateUtils;

public class SeatManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public SeatManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
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
