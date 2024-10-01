package com.jk;

public class Customer {

	private String name;
	private String cardNumber;
	private String pin;
	private int balance;
	
	public Customer(String name, String cardNumber, String pin) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.pin = pin;
	}
	



	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}




	@Override
	public String toString() {
		return "Customer [name=" + name + ", cardNumber=" + cardNumber + ", pin=" + pin + ", balance=" + balance + "]";
	}
	
	
	
	

}
