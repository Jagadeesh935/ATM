package com.jk;

import java.util.Scanner;

public class Main {
	public static Bank atm = new Bank();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		atm.register("Ram", "123", "123");
		atm.register("Sam", "456", "456");
		atm.login("123");
		atm.deposit(2000);
		atm.login("456");
		atm.deposit(5000);
		atm.login("123");
		atm.withdraw(500, "123");
		
		while (true) {
			System.out.println();
			System.out.println();

			displayLr();
			if (sc.nextInt() == 1) {
				System.out.println("Enter your card number");
				String cardNumber = sc.next();
				if (atm.login(cardNumber)) {
					displayHome();
					switch (sc.nextInt()) {
					case 1:
						deposit();
						break;
					case 2:
						withdraw();
						break;
					case 3:
						displayBalance();
						break;
					case 4:
						fundTransfer();
						break;
					case 5:
						changePin();
					default:
						System.out.println("Please enter the valid number");
					}
				}
			} else {
				System.out.println("Enter your name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter your Card number");
				String cardNumber = sc.next();
				System.out.println("Set your pin");
				String pin = sc.next();
				atm.register(name, cardNumber, pin);
				Thread.sleep(1000);
			}
		}

	}

	public static void deposit() {
		System.out.println("Enter the amount to deposit: ");
		atm.deposit(sc.nextInt());
	}

	public static void withdraw() {
		System.out.println("Enter the amount to withdraw");
		int amount = sc.nextInt();
		System.out.println("Enter the pin");
		String pin = sc.next();
		atm.withdraw(amount, pin);
	}

	public static void displayBalance() {
		System.out.println("Enter the pin");
		String pin = sc.next();
		atm.displayBalance(pin);
	}

	public static void fundTransfer() {
		System.out.println("Enter the card number");
		String num = sc.next();
		System.out.println("Enter the amount to transfer");
		int amt = sc.nextInt();
		System.out.println("Enter the pin");
		String pin = sc.next();
		atm.transferFund(num, pin, amt);
	}

	public static void changePin() {
		System.out.println("Enter your old pin");
		String oldpin = sc.next();
		System.out.println("Set new pin");
		String newpin = sc.next();
		atm.changePin(oldpin, newpin);
	}

	public static void displayLr() {
		System.out.println("""
				Choose one from below options
				    1 -> login
				    2 -> Register

				===>
						""");
	}

	public static void displayHome() {
		System.out.println("""
				Choose one from below options:
				    1 -> Deposit
				    2 -> Withdraw
				    3 -> Display balance
				    4 -> Transfer fund
				    5 -> Change pin

				===>
						""");
	}

}
