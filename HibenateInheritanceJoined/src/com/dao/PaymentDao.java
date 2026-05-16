package com.dao;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;

public interface PaymentDao {

	void saveCrediCard(CreditCard card);
	void saveCheque(Cheque cheque);
	Payment getPaymentById(int id);
	
	
	
}
