package com.app;

import java.time.LocalDate;
import java.util.List;

import com.dao.PaymentDAOImpl;
import com.dao.PaymentDao;
import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;

public class App {

	public static void main(String[] args) {

		PaymentDao dao = new PaymentDAOImpl();

		System.out.println("============= SAVE OPERATIONS =============");

		// Save CreditCard
		CreditCard card = new CreditCard(12345, "VISA");
		card.setPayAmt(5000);
		card.setPayDate(LocalDate.of(2026, 5, 15));
		dao.saveCredicard(card);

		// Save Cheque
		Cheque cheque = new Cheque(98765, "ICICI");
		cheque.setPayAmt(8000);
		cheque.setPayDate(LocalDate.of(2026, 5, 16));
		dao.saveCheque(cheque);

		System.out.println("============= READ BY ID =============");

		Payment p1 = dao.getPaymentById(card.getCardNum());
		System.out.println("Payment: " + p1);

		CreditCard c1 = dao.getCreditCardById(card.getCardNum());
		System.out.println("CreditCard: " + c1);

		Cheque ch1 = dao.getChequeById(cheque.getChequeNo());
		System.out.println("Cheque: " + ch1);

		System.out.println("============= GET ALL =============");

		List<Payment> payments = dao.getAllPayment();
		System.out.println("All Payments:");
		for (Payment p : payments) {
			System.out.println(p);
		}

		List<CreditCard> cards = dao.getAllCreditCards();
		System.out.println("All CreditCards:");
		for (CreditCard c : cards) {
			System.out.println(c);
		}

		List<Cheque> cheques = dao.getAllCheques();
		System.out.println("All Cheques:");
		for (Cheque c : cheques) {
			System.out.println(c);
		}

		System.out.println("============= UPDATE =============");

		card.setPayAmt(9999);
		dao.updateCreditCard(card);

		cheque.setChequeType("OPEN");
		dao.updateCheque(cheque);

		System.out.println("++++++++++++++++++++++++++++++++++++++");
		Payment payment = dao.getPaymentById(4);
		payment.setPayAmt(11111);
		dao.updatePayment(payment);
		
		System.out.println("---------------------------");

		System.out.println("Updates Done");

		System.out.println("============= DELETE =============");

		dao.deletePayment(card.getCardNum());
		System.out.println("Deleted Payment with ID: " + card.getCardNum());

		System.out.println("============= END =============");

	}

}
