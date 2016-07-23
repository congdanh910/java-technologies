package com.demo.java8.util.functional;

import java.util.function.Supplier;
/*
    Supplier<T> takes no parameter and return specific T type.
 */

public class WhatIsSupplier {

    public static void main (String[] args) {
        Supplier<String> s = () -> "Hello Supplier!";

        System.out.println(s.get());
    }
}
