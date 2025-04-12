package com.example.ThreadPool.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

	public static void main(String args[]) {

		ExecutorService kitchen = Executors.newFixedThreadPool(3);

		String[] orders = { "Biryani", "Dosa", "pulaw", "panipuri", "idli", "upma" };

		for (String eachOrder : orders) {
			kitchen.submit(new Order(eachOrder));
		}

		kitchen.shutdown(); // Kitchen close

	}
}
