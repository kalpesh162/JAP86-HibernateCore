package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "pid")
public class CreditCard extends Payment {
	private int cardNum;
	private String cardType;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public CreditCard(double payAmt, LocalDate payDate, int cardNum, String cardType) {
		super(payAmt, payDate);
		this.cardNum = cardNum;
		this.cardType = cardType;
	}

	public CreditCard(int cardNum, String cardType) {
		super();
		this.cardNum = cardNum;
		this.cardType = cardType;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNum=" + cardNum + ", cardType=" + cardType + "]";
	}

}
