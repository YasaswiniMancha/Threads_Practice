package com.example.deadLocks.toAvoidDeadLocks.LockManagement.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class DeliveryService {

	private int availableAgents = 3;
	private ReentrantLock reentrantlock = new ReentrantLock();

	public boolean assignAgent(int orderId) {
		if (reentrantlock.tryLock()) { // Non-blocking lock attempt 
			try {
				if (availableAgents > 0) {
					availableAgents--;
					System.out.println("Order " + orderId + " assigned agent. Agents left: " + availableAgents);
					return true;
				} else {
					System.out.println("Order " + orderId + ": No agents available");
					return false;
				}
			} finally {
				reentrantlock.unlock();
			}
		}
		return false;
	}
}

public class DeliveryServiceMain {
	public static void main(String args[]) {
		DeliveryService d = new DeliveryService();
		d.assignAgent(1);
		d.assignAgent(2);
		d.assignAgent(3);
		d.assignAgent(4);

	}
}
//Why ReentrantLock?: tryLock() valla deadlock avoid cheyyochchu, and timeout set cheyyochchu (ex: tryLock(1, TimeUnit.SECONDS))