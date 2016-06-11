package com.demo.java8.first;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Arrays.asList("a", "b").forEach(e -> System.out.println(e));
		System.out.println("-----------------------------------");

		Arrays.asList("a", "b").forEach((String e) -> System.out.println(e));
		System.out.println("-----------------------------------");

		final String separator = ",";
		Arrays.asList("a", "b").forEach((String e) -> System.out.println(e + separator));
		System.out.println("-----------------------------------");

		// interface static method
		System.out.println(Functional.staticMethod("Hello Java 8 with lambdas expression!"));
		System.out.println("-----------------------------------");

		// interface factory
		Functional functional = InterfaceFactory.create(FunctionalImpl::new);
		System.out.println(functional.method());
		System.out.println(functional.defaultMethod());
		System.out.println("-----------------------------------");

	}
}
