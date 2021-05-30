package com.flyaway.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static Configuration config;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		
		if(factory == null) {
			try {
				config = new Configuration().configure();
				config.addAnnotatedClass(com.flyaway.models.Flight.class);
				config.addAnnotatedClass(com.flyaway.models.Passager.class);
				config.addAnnotatedClass(com.flyaway.models.Purchased.class);
				config.addAnnotatedClass(com.flyaway.models.Seat.class);
				config.addAnnotatedClass(com.flyaway.models.Airline.class);
				config.addAnnotatedClass(com.flyaway.models.Airport.class);
				config.addAnnotatedClass(com.flyaway.models.Staff.class);
				
				builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
				factory = config.buildSessionFactory(builder.build());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return factory;
	}

}
