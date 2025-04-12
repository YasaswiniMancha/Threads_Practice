package com.example.deadLocks.toAvoidDeadLocks.LockManagement.synchornizedBlocks;

class Restaurant {
	private int burgerInventory = 10;

	public void reserveBurgers(int orderId, int quantity) {
		synchronized (this) { // Lock on Restaurant object
			if (burgerInventory >= quantity) {
				System.out.println("Order " + orderId + " reserved " + quantity + " burgers");
				burgerInventory -= quantity;
			} else {
				System.out.println("Order " + orderId + ": Not enough burgers!");
			}
		}
	}
}

class OrderThread extends Thread {
	private Restaurant restaurant;
	private int orderId, quantity;

	OrderThread(Restaurant restaurant, int orderId, int quantity) {
		this.restaurant = restaurant;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	public void run() {
		restaurant.reserveBurgers(orderId, quantity);
	}
}

public class SynchronizedBlocksMain {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		OrderThread t1 = new OrderThread(restaurant, 1, 5);
		OrderThread t2 = new OrderThread(restaurant, 2, 6);
		t1.start();
		t2.start();
	}
}