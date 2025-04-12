package com.example.deadLocks.toAvoidDeadLocks.LockManagement.Semaphore;
import java.util.concurrent.Semaphore;

class Kitchen {
	
	//Semaphore valla kitchen overload avvadhu, 5 orders matrame process avtayi.
    private Semaphore semaphore = new Semaphore(5); // Max 5 orders

    public void processOrder(int orderId) {
        try {
            semaphore.acquire(); // Permit teesuko
            System.out.println("Order " + orderId + " processing in kitchen");
            Thread.sleep(200); // Simulate cooking
            System.out.println("Order " + orderId + " done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Permit release cheyyi
        }
    }
}

public class KitchenMain{
	public static void main(String args[]) {
		Kitchen k= new Kitchen();
		k.processOrder(1);
		k.processOrder(2);
		k.processOrder(3);
		k.processOrder(4);
		k.processOrder(5);
		k.processOrder(6);
		k.processOrder(7);
	}
}