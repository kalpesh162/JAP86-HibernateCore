package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;
import com.utility.HibernateUtility;

public class PaymentDAOImpl implements PaymentDao {

	@Override
	public void saveCredicard(CreditCard card) {
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
		} finally {
			session.close();
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
		} finally {
			session.close();
		}
	}

	public Payment getPaymentById(int id) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();

		Payment payment = null;

		try {
			payment = session.get(Payment.class, id);
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}

		return payment;
	}

	public CreditCard getCreditCardById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		CreditCard card = null;
		try {
			card = session.get(CreditCard.class, id);
		} finally {
			session.close();
		}
		return card;
	}

	public Cheque getChequeById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Cheque cheque = null;
		try {
			cheque = session.get(Cheque.class, id);
		} finally {
			session.close();
		}
		return cheque;
	}

	public List<Payment> getAllPayment() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		List<Payment> payments = null;

		try {
			payments = session.createQuery("from Payment", Payment.class).getResultList();
		} finally {
			session.close();
		}
		return payments;

	}

	public List<CreditCard> getAllCreditCards() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		List<CreditCard> list = null;

		try {
			list = session.createQuery("from CreditCard", CreditCard.class).getResultList();
		} finally {
			session.close();
		}

		return list;
	}

	public List<Cheque> getAllCheques() {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();

		List<Cheque> cheques = null;

		try {

			cheques = session.createQuery("from Cheque", Cheque.class).getResultList();

		} finally {
			session.close();
		}

		return cheques;
	}



	@Override
	public void updatePayment(Payment payment) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			System.out.println("((()))");
			session.merge(payment);

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();

			throw e;

		} finally {
			session.close();
		}
	}

	@Override
	public void updateCreditCard(CreditCard card) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			session.merge(card);

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();

			throw e;

		} finally {
			session.close();
		}
	}

	@Override
	public void updateCheque(Cheque cheque) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			session.merge(cheque);

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();

			throw e;

		} finally {
			session.close();
		}
	}

	

	@Override
	public void deletePayment(int id) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			Payment payment = session.get(Payment.class, id);

			if (payment != null) {
				session.remove(payment);
			}

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();

			throw e;

		} finally {
			session.close();
		}
	}

}
