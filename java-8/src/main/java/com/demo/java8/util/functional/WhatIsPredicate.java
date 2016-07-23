package com.demo.java8.util.functional;

import java.util.function.Predicate;
/*
    Predicate<R> takes one R parameter and return boolean value
 */

public class WhatIsPredicate {

    public static void main (String[] args) {
        Predicate<String> p = s -> {
            if ( s != null ) {
                return true;
            }
            else {
                return false;
            }
        };
        System.out.println(p.test(""));
    }
}
