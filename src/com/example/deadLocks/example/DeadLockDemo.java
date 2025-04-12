package com.example.deadLocks.example;

class DeadlockDemo {

	String resource1 = "Pen";
	String resource2 = "Pencil";

	Thread t1 = new Thread(() -> {
		synchronized (resource1) {
			System.out.println("T1: Locked Pen");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			synchronized (resource2) {
				System.out.println("T1: Wants Pencil");
			}
		}
	});

	Thread t2 = new Thread(() -> {
		synchronized (resource2) {
			System.out.println("T2: Locked Pencil");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			synchronized (resource1) {
				System.out.println("T2: Wants Pen");
			}
		}
	});

	public void startThreads() {
		t1.start();
		t2.start();
	}
}

