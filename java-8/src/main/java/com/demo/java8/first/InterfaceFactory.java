package com.demo.java8.first;

import java.util.function.Supplier;

public interface InterfaceFactory {
	static Functional create(Supplier<Functional> supplier) {
		return supplier.get();
	}

}
