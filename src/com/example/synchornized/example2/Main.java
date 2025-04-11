package com.example.synchornized.example2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter train no: ");
        int trainNo = sc.nextInt();
        System.out.println("Enter how many seats are requested for passenger1: ");
        int requestedSeats1 = sc.nextInt();
        System.out.println("Enter how many seats are requested for passenger2: ");
        int requestedSeats2 = sc.nextInt();

        Train train = new Train(trainNo); // Create train object

        // Create two passengers with same train and number of seats
        Passenger p1 = new Passenger(train, requestedSeats1, trainNo);
        Passenger p2 = new Passenger(train, requestedSeats2, trainNo);

        p1.setName("Passenger-1");
        p2.setName("Passenger-2");

        p1.start(); // Passenger-1 booking
        p2.start(); // Passenger-2 booking

        sc.close(); // Close scanner
    }
}