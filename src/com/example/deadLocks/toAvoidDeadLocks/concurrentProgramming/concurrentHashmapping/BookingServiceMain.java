package com.example.deadLocks.toAvoidDeadLocks.concurrentProgramming.concurrentHashmapping;
import java.util.concurrent.ConcurrentHashMap;

class BookingService {
    ConcurrentHashMap<Integer, Boolean> seatStatus = new ConcurrentHashMap<>();

    void bookSeat(int seatId, String user) {
        seatStatus.putIfAbsent(seatId, false);
        if (!seatStatus.get(seatId)) {
            seatStatus.put(seatId, true);
            System.out.println(user + " booked seat " + seatId);
        } else {
            System.out.println("Dear "+user +", Seat " + seatId + " already booked!");
        }
    }
}

public class BookingServiceMain {
	public static void main(String args[]) {
		BookingService b = new BookingService();
		b.bookSeat(1, "Yash");
		b.bookSeat(2, "sri");
		b.bookSeat(3, "balu");
		b.bookSeat(1, "dora");
		b.bookSeat(4, "venky");
	}
}

//Multiple threads okesari seatStatus ni access chesina, race condition ravadhuu. ConcurrentHashMap internal locking handle chestundi.