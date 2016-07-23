package com.demo.java8.util.functional;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
/*
    DoubleFunction<R> takes one double parameter and returns the specific type. The method is apply.
        DoubleFunction<R> df = (d)-> { return R };

    IntFunction<R>  takes one int parameter and returns the specific type. The method is apply.
        IntFunction<R> di = (i)-> { return R };

    LongFunction<R>  takes one long parameter and returns the specific type. The method is apply.
        LongFunction<R> dl = (l)-> { return R };

 */

public class WhatIsTFunction {

    public static void main (String[] args) {
        DoubleFunction<String> df = (d) -> "DoubleFunction = " + d;
        System.out.println(df.apply(5));


        IntFunction<String> di = (i) -> "IntFunction = " + i;
        System.out.println(di.apply(10));


        LongFunction<String> dl = (l) -> "LongFunction = " + l;
        System.out.println(dl.apply(15));
    }
}
