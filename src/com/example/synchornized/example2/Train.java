package com.example.synchornized.example2;

public class Train {

	int trainNo;
	int availableSeats = 6;

	public Train(int trainNo) {
		this.trainNo = trainNo;
	}
	
	// Synchronized method to book tickets
	synchronized void bookTickets(int requestedSeats, int trainNo) {
		if (this.trainNo == trainNo) { // Check if train number matches
			if (availableSeats >= requestedSeats) {
				System.out.println(Thread.currentThread().getName() + " booking " + requestedSeats + " seats in train "
						+ trainNo + ".");
				availableSeats -= requestedSeats; // Update seats
			} else {
				System.out.println("Sorry, " + Thread.currentThread().getName() + " train " + trainNo + " has only "
						+ availableSeats + " seats available but you have requested " + requestedSeats + ".");
			}
		} else {
			System.out.println("No such train exists for train number: " + trainNo);
		}
	}
}