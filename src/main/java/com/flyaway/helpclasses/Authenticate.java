package com.flyaway.helpclasses;

import org.hibernate.query.Query;

import com.flyaway.models.Passager;
import com.flyaway.util.HibernateUtils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Authenticate {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	//Use to retrieve passenger information
	private int passengerId;

	public Authenticate() {

		factory= HibernateUtils.getSessionFactory();
		try {
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
				if (username.equalsIgnoreCase(passager.getEmail()) && password.equals(passager.getPassword())) {
					passengerId = passager.getPassagerId();
					return true;
				}
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
			Passager passager = new Passager(fname, lname, birthday, address, phone, password, email);
			session.save(passager);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			session.close();
			return false;
		}
	}
	
	public int getId() {
		return passengerId;
	}

}
