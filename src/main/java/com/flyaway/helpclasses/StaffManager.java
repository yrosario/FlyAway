package com.flyaway.helpclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.models.Staff;

public class StaffManager {
	
	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public StaffManager() {
		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.models.Staff.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addStaff(String fname, String lname, String phone, String address, String email) {
		
		try {
			Staff staff = new Staff(fname, lname, phone, address, email);
			session.save(staff);
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
