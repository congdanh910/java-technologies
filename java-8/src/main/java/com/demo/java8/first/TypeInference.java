package com.demo.java8.first;

public class TypeInference<T> {
	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault(T value, T defaultValue) {
		return (value != null) ? value : defaultValue;
	}

	public static void main(String[] args) {
		final TypeInference<String> value = new TypeInference<>();
		String a = value.getOrDefault("22", TypeInference.defaultValue());
		System.out.println(a);

		String b = value.getOrDefault(null, TypeInference.defaultValue());
		System.out.println(b);
	}
}