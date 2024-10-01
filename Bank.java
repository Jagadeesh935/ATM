package com.jk;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<Customer> customers = new ArrayList<>();
	private Customer currentUser;

	private Customer getCustomer(String cardNumber) {

		for (Customer c : customers) {
			if (c.getCardNumber().equals(cardNumber)) {
				return c;
			}
		}

		return null;
	}

	public boolean register(String name, String cardNumber, String pin) {
		if (getCustomer(cardNumber) != null) {
			System.out.println("Card number already exist");
			return false;
		}
		customers.add(new Customer(name, cardNumber, pin));
		System.out.println("Registration successful");
		return true;
	}

	public boolean login(String cardNumber) {
		currentUser = getCustomer(cardNumber);
		if (currentUser == null) {
			System.out.println("User doesn't exist");
			return false;
		}
		System.out.println("Hello " + currentUser.getName());

		return true;
	}

	private void logout() {
		System.out.println("Thankyou for banking");
		currentUser = null;
	}

	public void displayBalance(String pin) {
		if (currentUser.getPin().equals(pin)) {
			System.out.println("Avaliable Balance: " + currentUser.getBalance());
		} else {
			System.out.println("Invalid pin");
		}
		logout();
	}

	public void deposit(int amount) {
		currentUser.setBalance(currentUser.getBalance() + amount);
		System.out.println(amount + " deposited");
		logout();
	}

	public void withdraw(int amount, String pin) {
		if (currentUser.getPin().equals(pin)) {
			if (currentUser.getBalance() < amount) {
				System.out.println("Insufficient balance");
			} else {
				currentUser.setBalance(currentUser.getBalance() - amount);
				System.out.println(amount + " withdrawn");
			}
		} else {
			System.out.println("Invalid pin");
		}
		logout();
	}

	public void transferFund(String toCardNumber, String pin, int amt) {
		if (currentUser.getPin().equals(pin)) {
			Customer toCustomer = getCustomer(toCardNumber);
			currentUser.setBalance(currentUser.getBalance() - amt);
			toCustomer.setBalance(toCustomer.getBalance() + amt);
			System.out.println(amt + " transferred to " + toCustomer.getName());
		} else {
			System.out.println("Invalid pin");
		}
		logout();
	}

	public void changePin(String oldPin, String newPin) {
		if (currentUser.getPin().equals(oldPin)) {
			currentUser.setPin(newPin);
			System.out.println("Pin changed");
		} else {
			System.out.println("Invalid pin");
		}
	}

}
