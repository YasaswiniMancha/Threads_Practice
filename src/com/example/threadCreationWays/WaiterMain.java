package com.example.threadCreationWays;

public class WaiterMain {
	public static void main(String args[]) {

		Waiter w1 = new Waiter("Taking order");
		Waiter w2 = new Waiter("Supplying water meanwhile");
		Waiter w3 = new Waiter("Informing chef to prepare food");

		Thread t1 = new Thread(w1); // thread creation for each object/task
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);

		t1.start(); // Runnable: thread is ready to run but CPU is not allocated
		t2.start();
		// Running: when CPU is allocated to thread , then run() method will get
		// executed.

		try {
			t3.sleep(300); // blocked state or sleep state
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Threads ended");
	}
}
