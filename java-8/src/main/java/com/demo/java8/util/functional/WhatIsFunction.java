package com.demo.java8.util.functional;

import java.util.function.Function;

/*
    Function takes one T parameter and returns specific type R.
       Function<T, R> f = (t) -> { return r; }
 */
public class WhatIsFunction {

    public static void main (String[] args) {
        Function<Integer, String> f = i -> i.toString();

        System.out.println(f.apply(10));
    }
}
