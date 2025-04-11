package com.example.synchrornizedKeywordInThreads.example2;

public class Passenger extends Thread {
    Train train;
    int numOfSeats;
    int trainNo;

    public Passenger(Train train, int numOfSeats, int trainNo) {
        this.train = train;
        this.numOfSeats = numOfSeats;
        this.trainNo = trainNo;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    @Override
    public void run() {
        train.bookTickets(numOfSeats, trainNo); // Call bookTickets method
    }
}