package com.demo.java8.first;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = "test.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("line : " + line);
			}
		}
	}
}
