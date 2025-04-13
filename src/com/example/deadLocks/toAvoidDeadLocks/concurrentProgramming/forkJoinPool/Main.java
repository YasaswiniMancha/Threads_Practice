package com.example.deadLocks.toAvoidDeadLocks.concurrentProgramming.forkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class RouteCalculator extends RecursiveTask<Integer> {
    private int[] orders;
    private int start, end;

    RouteCalculator(int[] orders, int start, int end) {
        this.orders = orders;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 10) { // Small task
            int sum = 0;
            for (int i = start; i < end; i++) sum += orders[i];
            return sum;
        } else { // Split task
            int mid = (start + end) / 2;
            RouteCalculator left = new RouteCalculator(orders, start, mid);
            RouteCalculator right = new RouteCalculator(orders, mid, end);
            left.fork(); // Async execution
            return right.compute() + left.join();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] orders = new int[100]; // Dummy data
        RouteCalculator task = new RouteCalculator(orders, 0, orders.length);
        int result = pool.invoke(task);
        System.out.println("Total route cost: " + result);
    }
}