package com.flyaway.authenticate;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.passager.Passager;

public class Authenticate {

	private Configuration config;
	private StandardServiceRegistryBuilder builder;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public Authenticate() {

		try {
			config = new Configuration().configure();
			config.addAnnotatedClass(com.flyaway.passager.Passager.class);
			builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			session = config.buildSessionFactory().openSession();
			factory = config.buildSessionFactory(builder.build());
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasAccess(String username, String password) {

		try {
			@SuppressWarnings("unchecked")
			Query<Passager> query = (session.createQuery(("FROM Passager WHERE email='" + username+"'")));
			List<Passager> passagerList = query.list();

			Passager passager = passagerList.get(0);
			System.out.println("THIS IS THE VALUES OF PASSAGER: " + passager.toString());

			transaction.commit();
			if (passager != null) {
				if (username.equalsIgnoreCase(passager.getEmail()) && password.equals(passager.getPassword()))
					return true;
				else
					return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean createUser(String fname, String lname, String birthday, String address, String phone,
			String password, String email) {

		try {
			Passager passager = new Passager(0, fname, lname, birthday, address, phone, password, email);
			session.save(passager);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			session.close();
			return false;
		}
	}

}
