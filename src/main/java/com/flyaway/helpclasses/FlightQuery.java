package com.flyaway.helpclasses;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.flyaway.models.Flight;

public class FlightQuery {

	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public FlightQuery() {

		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.models.Flight.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Flight> getFlights(String from, String destination, String departureDate, String returningDate) {

		/*
		 * String from = request.getParameter("from"); String destination =
		 * request.getParameter("to"); String departureDate =
		 * request.getParameter("departureDate"); String returningDate =
		 * request.getParameter("returningDate");
		 */
		try {
			// Query the flight table
			@SuppressWarnings("unchecked")
			Query<Flight> query = (session.createQuery("FROM Flight"));
			List<Flight> flightList = query.list();

			//commit 
			transaction.commit();
			
			// close session
			session.close();

			// Return list of flights found
			return flightList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// Close database connection
			session.close();
		}
	}

}
