package com.demo.java8.util.functional;

import java.util.function.BiFunction;

/*
    BiFunction<T, U, R> biFunction = (t, u) - > { return r; };
    BiFunction takes 2 parameter and return type.
    BiFunction returns the value with the specified type.
    The function method is apply(Object, Object)
 */
public class WhatIsBiFunction {

    public static void main (String[] args) {

        BiFunction<Integer, Integer, String> biFunction = (i1, i2) -> {
            if ( i1.equals(i2) ) {
                return "Result is plus i1 and i2 = " + (i1 + i2);
            }
            return "Result is multiplication i1 and i2 = " + (i1 * i2);
        };

        System.out.println(biFunction.apply(10, 20));

        System.out.println(biFunction.apply(10, 10));
    }
}
