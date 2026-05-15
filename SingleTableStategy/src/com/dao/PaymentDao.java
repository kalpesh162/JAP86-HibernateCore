package com.dao;

import com.entity.Cheque;
import com.entity.CreditCard;

public interface PaymentDao {
	
	void saveCredicard(CreditCard card);
	void saveCheque(Cheque cheque);

}
