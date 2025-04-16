package com.example.deadLocks.toAvoidDeadLocks.concurrentProgramming.concurrentHashmapping;

import java.util.concurrent.ConcurrentHashMap;

class OrderService {

	private ConcurrentHashMap<Integer, String> activeOrders = new ConcurrentHashMap<>();

	public void placeOrder(int orderId, String details) {
		activeOrders.put(orderId, details); // Thread-safe write
		System.out.println("Order " + orderId + " placed: " + details);
	}

	public String getOrderStatus(int orderId) {
		return activeOrders.getOrDefault(orderId, "Not found"); // Thread-safe read
	}
}

public class OrderServiceMain {
	public static void main(String args[]) {
		OrderService o = new OrderService();
		o.placeOrder(1, "pulaw");
		o.getOrderStatus(1);
	}
}

/*
 * Java lo java.util.concurrent package threading ni efficient ga handle
 * chestundi. a. ConcurrentHashMap Ela Use Chesamu: Booking system lo seat
 * availability track cheyyadaniki ConcurrentHashMap use chestamu, endukante idi
 * thread-safe. Example: Seat ID and status store cheyyali. java
 */