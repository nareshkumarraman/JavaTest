package com.hiq;

public interface TestInterfacetwo {

	default void log(String s){
		System.out.println("TestInterfacetwo 00000000" + s);
	}
}
