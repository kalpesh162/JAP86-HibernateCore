package com.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;
	private double payAmt;
	private LocalDate payDate;

	public Payment() {
		
	}

	public Payment(double payAmt, LocalDate payDate) {
		super();
		this.payAmt = payAmt;
		this.payDate = payDate;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public double getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(double payAmt) {
		this.payAmt = payAmt;
	}

	public LocalDate getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", payAmt=" + payAmt + ", payDate=" + payDate + "]";
	}

}
