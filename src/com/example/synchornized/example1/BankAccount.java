package com.example.synchornized.example1;

public class BankAccount {

	synchronized void withdraw(int withDrawAmount) { // Synchronized method
		int balance = 2000;
		System.out.println("balance for : " + Thread.currentThread().getName() + " is " + balance);
		if (balance >= withDrawAmount) {
			System.out.println(Thread.currentThread().getName() + " withdrawing " + withDrawAmount);
			balance -= withDrawAmount;
			System.out.println("Balance: " + balance);
		} else {
			System.out.println("Insufficient balance for " + Thread.currentThread().getName());
		}
	}
}
