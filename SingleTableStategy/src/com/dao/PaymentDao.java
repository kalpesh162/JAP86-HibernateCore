package com.dao;

import java.util.List;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;

public interface PaymentDao {

	void saveCredicard(CreditCard card);

	void saveCheque(Cheque cheque);

	Payment getPaymentById(int id);

	CreditCard getCreditCardById(int id);

	Cheque getChequeById(int id);

	List<Payment> getAllPayment();

	List<CreditCard> getAllCreditCards();

	List<Cheque> getAllCheques();

	void updatePayment(Payment payment);

	void updateCreditCard(CreditCard card);

	void updateCheque(Cheque cheque);

	void deletePayment(int id);
}