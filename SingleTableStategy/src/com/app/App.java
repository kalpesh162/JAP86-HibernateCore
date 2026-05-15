package com.app;

import java.time.LocalDate;

import com.dao.PaymentDAOImpl;
import com.dao.PaymentDao;
import com.entity.CreditCard;

public class App {

	public static void main(String[] args) {
		
		PaymentDao dao=new PaymentDAOImpl();
		
		CreditCard card=new CreditCard(12345,"VISA");
		card.setPayAmt(5000);
		
		card.setPayDate(LocalDate.of(2026, 05, 15));
		
		
		System.out.println("---------------------");
		dao.saveCredicard(card);
		System.out.println("---------------------");
		
		
		
		
		
		
	}
	
}
