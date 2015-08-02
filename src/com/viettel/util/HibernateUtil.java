package com.viettel.util;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.DateType;

/**
 * 
 * @author hieuph
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	public static Session getSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		return session;
	}

	// -------------
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static long getSequence(String sequenceName) throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String strQuery = "SELECT " + sequenceName + " .NextVal FROM Dual";
		Query queryObject = session.createSQLQuery(strQuery);
		BigDecimal bigDecimal = (BigDecimal) queryObject.uniqueResult();
		session.close();
		return bigDecimal.longValue();
	}

	public static Date getSysdate() throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String strQuery = "SELECT sysdate as system_datetime FROM Dual";
		SQLQuery queryObject = session.createSQLQuery(strQuery);
		queryObject.addScalar("system_datetime", DateType.INSTANCE);
		Date sysdate = (Date) queryObject.uniqueResult();
		session.close();
		return sysdate;
	}

}
