package com.example.synchrornizedKeywordInThreads.example1;

public class Mainclass {
	
     public static void main(String args[]) {
    	 
    	 BankAccount acc1= new BankAccount();  
    	 
    	 WithdrawThread t1= new WithdrawThread(acc1, 30000);
    	 WithdrawThread t2 = new WithdrawThread(acc1, 800);

         t1.setName("Thread-1");
         t2.setName("Thread-2");

         t1.start();
         t2.start();
    	
    	 
     }
}
