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

public class OrderServiceMain{
	public static void main(String args[]) {
		OrderService o= new OrderService();
		o.placeOrder(1, "pulaw");
		o.getOrderStatus(1);
		}
}