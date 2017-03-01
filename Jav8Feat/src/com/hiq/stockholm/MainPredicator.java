package com.hiq.stockholm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainPredicator {
	
	public static void main(String[] args) {
		Customer c1 = new Customer("A",20,"M");
		Customer c2 = new Customer("B",25,"M");
		Customer c3 = new Customer("C",28,"M");
		Customer c4 = new Customer("A",20,"F");
		Customer c5 = new Customer("E",16,"M");
		Customer c6 = new Customer("F",18,"F");
		
		List<Customer> listcust =  Arrays.asList(new Customer[]{c1,c2,c3,c4,c5,c6});
		
		List<Customer> checkAge = checkAge(listcust, (Customer c) -> "M".equals(c.getGender()));
		
		checkAge.forEach(i -> System.out.println(i.getName()));
		
		List<Customer> checkAge2 = checkAge(listcust,MainPredicator::checkName);
		checkAge2.forEach(i->System.out.println(i.getName()));
		
		
	}
	
	public static List<Customer> checkAge(List<Customer> customer,Predicate<Customer> p){
			List<Customer> list = new ArrayList<Customer>();
			for(Customer customers: customer){
				if(p.test(customers)){
					list.add(customers);
				}
			}
			return list;
	}
	
	public static boolean checkName(Customer cust){
		return "F".equals(cust.getName());
	}
	
}
