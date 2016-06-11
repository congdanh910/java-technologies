package com.demo.java8.first;

@FunctionalInterface
public interface Functional {
	String method();

	// interface default method
	default String defaultMethod() {
		return "This is default method!";
	}

	// interface static method
	static String staticMethod(String hello) {
		return hello;
	}
}
