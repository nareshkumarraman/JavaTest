package com.hiq;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

interface A{
	void test(int i);
}

class MainClass implements A{
	public void test(int i){
		System.out.println("MainClass");
	}
}

public class IntCheck {
	public static void main(String[] args) {
		MainClass incheck = new MainClass();
		incheck.test(7);
		
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(Instant.now());
		
		A obj;
		
		/*obj = new A() {
			
			@Override
			public void test() {
				System.out.println("Inner class");
				
			}
		};*/
		
		/*obj = () -> {
			System.out.println("Inner class");
		};*/
		
		obj = (i)->System.out.println("Inner class" + i);
		
		obj.test(8);
	}
}