package com.demo.java8.util.functional;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/*
    DoublePredicate takes one double parameter and returns boolean value. The method is test.
        DoublePredicate dp = (d) -> {boolean};

    IntPredicate takes one integer parameter and returns boolean value. The method is test.
        IntPredicate ip = (d) -> {boolean};

    LongPredicate takes one long parameter and returns boolean value. The method is test.
        LongPredicate lp = (d) -> {boolean};
 */
public class WhatIsTPredicate {

    public static void main (String[] args) {
        DoublePredicate dp = (d) -> true;
        System.out.println("DoublePredicate = " + dp.test(2));

        IntPredicate ip = (i) -> false;
        System.out.println("IntPredicate = " + ip.test(1));

        LongPredicate lp = (l) -> true;
        System.out.println("LongPredicate = " + lp.test(3));
    }
}
