package com.demo.java8.util.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
    BiConsumer<T, U> biConsumer = (t, u) - > {};
    BiConsumer takes 2 parameters and not return anything.
    We can use for the terminal operations. Something likes println or calculate
    This one usually uses for some methods as peek(), foreach(), foreachOrdered().
    The function method is accept(Object, Object)
 */
public class WhatIsBiConsumer {

    public static void main (String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Jonh");
        map.put(2, "Jonh 1");
        map.put(3, "Jonh 2");
        map.put(4, "Jonh 3");
        map.put(5, "Jonh 4");
        map.put(6, "Jonh 5");

        // Note that we are writing on one line
        BiConsumer<Integer, String> biConsumer = (no, name) -> System.out.println("No." + no + ", name : " + name);
        map.forEach(biConsumer);

        BiConsumer<Integer, Integer> calculate = (i1, i2) -> System.out.println("i1 * i2 = " + i1 * i2);
        calculate.accept(10, 10);

        Map<Integer, String> map2 = map;
        map2.put(7, "What the hell is that?");

        // Note that we are writing on multi line using {}
        map2.forEach((key, value) -> {
            if ( key == 7 ) {
                System.out.println("key = " + key + ", value = " + value);
            }
        });

    }
}
