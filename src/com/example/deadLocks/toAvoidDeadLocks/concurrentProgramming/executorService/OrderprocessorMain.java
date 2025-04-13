package com.example.deadLocks.toAvoidDeadLocks.concurrentProgramming.executorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OrderProcessor implements Runnable {
    private int orderId;
    OrderProcessor(int orderId) {
        this.orderId = orderId;
    }
    public void run() {
        System.out.println("Processing order " + orderId + " on " + Thread.currentThread().getName());
    }
}

public class OrderprocessorMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 threads
        for (int i = 1; i <= 20; i++) {
            executor.submit(new OrderProcessor(i));
        }
        executor.shutdown();
    }
}