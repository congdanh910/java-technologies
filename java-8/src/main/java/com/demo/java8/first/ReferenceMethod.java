package com.demo.java8.first;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ReferenceMethod {
	public static ReferenceMethod create(final Supplier<ReferenceMethod> supplier) {
		return supplier.get();
	}

	public static void collide(final ReferenceMethod car) {
		System.out.println("Collided :" + car.toString());
	}

	public void follow(final ReferenceMethod another) {
		System.out.println("Following the : " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired : " + this.toString());
	}

	public static void main(String[] args) {
		final ReferenceMethod referenceMethod = ReferenceMethod.create(ReferenceMethod::new);
		final List<ReferenceMethod> methods = Arrays.asList(referenceMethod);

		methods.forEach(ReferenceMethod::collide);
		methods.forEach(ReferenceMethod::repair);

		final ReferenceMethod police = ReferenceMethod.create(ReferenceMethod::new);
		methods.forEach(police::follow);
	}
}