package com.demo.java8.util.functional;

import java.util.function.UnaryOperator;
/*
    UnaryOperator<T> takes one T parameter and returns the specific T type.
 */
public class WhatIsUnaryOperator {

    public static void main (String[] args) {
        UnaryOperator<String> u = s -> s;

        System.out.println(u.apply("Hello UnaryOperator!"));
    }
}
