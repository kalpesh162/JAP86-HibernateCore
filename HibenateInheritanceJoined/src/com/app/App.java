package com.app;

import java.time.LocalDate;

import com.dao.PaymentDao;
import com.dao.PaymentDaoImpl;
import com.entity.Cheque;
import com.entity.CreditCard;

public class App {

	public static void main(String[] args) {
		PaymentDao dao = new PaymentDaoImpl();
		/*
		
		CreditCard card1 = new CreditCard(25254, "MASTER");
		card1.setPayAmt(5457);
		card1.setPayDate(LocalDate.of(2026, 6, 26));

		Cheque cheque1 = new Cheque(236547, "Post-Dated");
		cheque1.setPayAmt(32547);
		cheque1.setPayDate(LocalDate.of(2026, 5, 29));
		System.out.println("SAVE CHEQUE");

		dao.saveCheque(cheque1);
		System.out.println("SAVE CARD");
		dao.saveCrediCard(card1);
*/
		System.out.println("----------------------------");

		System.out.println("Read Payment Details BY ID");
		
		System.out.println(dao.getPaymentById(1));
		
	}

}
