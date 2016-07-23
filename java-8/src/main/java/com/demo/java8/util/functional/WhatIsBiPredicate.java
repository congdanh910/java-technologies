package com.demo.java8.util.functional;

import java.util.function.BiPredicate;

/*
    BiPredicate<T, U> bi = (t,u) -> { return boolean; };
    BiPredicate takes 2 parameters and return boolean type.
    The function method is test(Object, Object).
 */
public class WhatIsBiPredicate {

    public static void main (String[] args) {
        BiPredicate<String, String> biPredicate = (s1, s2) -> {
            if ( s1.startsWith(s2) ) {
                return true;
            }
            return false;
        };

        System.out.println(biPredicate.test("Hello Danh Ho", "Hello"));

        BiPredicate<String, String> biPredicate2 = (s1, s2) -> {
            if ( s1.endsWith(s2) ) {
                return true;
            }
            return false;
        };

        System.out.println(biPredicate.or(biPredicate2).test("Hello Danh Ho", "aaa"));
        System.out.println(biPredicate.and(biPredicate2).test("Ho Hello Danh Ho", "Ho"));
    }
}
