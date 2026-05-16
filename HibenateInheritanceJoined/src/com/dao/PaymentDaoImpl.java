package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;
import com.utility.HibernateUtility;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void saveCrediCard(CreditCard card) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(card);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public void saveCheque(Cheque cheque) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(cheque);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}

	}

	@Override
	public Payment getPaymentById(int id) {

		Payment payments;
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		try {
			payments = (Payment) session.get(Payment.class, id);
		} finally {
			session.close();
		}
		return payments;
	}

}
