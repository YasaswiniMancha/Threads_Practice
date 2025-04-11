package com.example.threadCreationWays.usingRunnableInterface;

public class RunnableMainClass {
	public static void main(String args[]) {
	RunnableClass r= new RunnableClass();
     Thread t= new Thread(r);
     // or use
     //Thread t= new Thread(new RunnableClass());
     //Ee method lo Thread class ki Runnable object pass chesi start chestam.
     t.start();
	}
}
