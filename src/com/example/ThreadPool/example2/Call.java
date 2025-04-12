package com.example.ThreadPool.example2;

public class Call implements Runnable {

	int callNo;

	public Call(int callNo) {
		this.callNo = callNo;
	}

	@Override
	public void run() {

		System.out.println("call " + callNo + " accepted by " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("call " + callNo + " completed by " + Thread.currentThread().getName());
	}

}
