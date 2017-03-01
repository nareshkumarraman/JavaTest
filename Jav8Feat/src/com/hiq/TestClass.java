package com.hiq;

import java.util.ArrayList;
import java.util.List;

public class TestClass extends AbstractTest implements TestInterfaceOne {

	/*@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	public void log(String s){
		System.out.println("TestClass 00000000" + s);
	}*/
	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	/*public void print(String s){
		System.out.println("Main class");
	}*/
	
	public static void main(String args[]){
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.forEach(i -> System.out.println(i));
		TestClass obj = new TestClass();
		obj.print("");
		obj.newtest("test method");
		TestInterfaceOne.isNull("abc");
		obj.isNull("abc");
	}

}
