package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.models.Flight;
import com.flyaway.models.Passager;
import com.flyaway.models.Purchased;
import com.flyaway.util.HibernateUtils;

public class BuyFlightManager {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public BuyFlightManager() {
		
		factory = HibernateUtils.getSessionFactory();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public boolean buy(int flightId, int passagerId) {
		
		try {
			Flight flight = session.get(Flight.class, flightId);
			Passager passager = session.get(Passager.class, passagerId);
			
			Purchased purchased = new Purchased();
			flight.setPurchases(purchased);
			passager.setPurchases(purchased);
			
			//session.save(flightList.get(0));
			session.save(purchased);
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
