package com.example.ThreadPool.example2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallCentre {

	public static void main(String args[]) {

		ExecutorService callCentreStaff = Executors.newFixedThreadPool(5);

		int[] calls = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int eachCall : calls) {
			callCentreStaff.submit(new Call(eachCall));
		}
		
		callCentreStaff.shutdown();
		try {
		    callCentreStaff.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

}
