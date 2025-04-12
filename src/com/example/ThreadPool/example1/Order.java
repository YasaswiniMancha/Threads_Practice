package com.example.ThreadPool.example1;

public class Order implements Runnable {

	String orderName;

	Order(String orderName) {
		this.orderName = orderName;
	}

	public void run() {

		System.out.println("Chef " + Thread.currentThread().getName() + " preparing " + orderName);

		try {
			Thread.sleep(1000); // Time takes to prepare a order.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Chef " + Thread.currentThread().getName() + " completed " + orderName);
	}

}
