package com.hiq;

public class Threaddemo {
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Test Method");
			}
		});
		
		t.start();
		
		Runnable r = ()->System.out.println("Test Method");
		r.run(); 
		
		Thread thr = new Thread(()->System.out.println("Test Method"));
		thr.start();
		
	}
}
