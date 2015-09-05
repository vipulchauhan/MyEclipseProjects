package org.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
	// private static SessionFactory sessionFactory = new
	// Configuration().configure().buildSessionFactory();
	private static Session session = null;

	public static void openSession() {
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
	}

	public static void closeSession() {
		if (session != null && session.isOpen()) {
			session.close();

		}

	}

	public static void closeSessionFacotry() {
		if (!sessionFactory.isClosed())
			sessionFactory.close();
	}

	public static boolean save(Object obj) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return true;

	}

	public static Session getSession() {
		return session;
	}

}
