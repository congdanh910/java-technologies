package com.demo.java8.util.functional;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

/*
    DoubleConsumer takes one double parameter and return void. The method is accept
        DoubleConsumer d = (d) -> {};

    IntConsumer takes one integer parameter and return void. The method is accept
        IntConsumer i = (i) -> {};

    LongConsumer takes one long parameter and return void. The method is accept
        LongConsumer  l = (l) -> {};

    ObjDoubleConsumer takes 2 parameter and return void. The method is accept
        ObjDoubleConsumer<T> ob = (t,d) -> {};

    ObjIntConsumer takes 2 parameter and return void. The method is accept
        ObjIntConsumer<T> oi = (t,i) -> {};

    ObjLongConsumer takes 2 parameter and return void. The method is accept
        ObjLongConsumer<T> ol = (t,l) -> {};
 */
public class WhatIsTConsumer {

    public static void main (String[] args) {
        DoubleConsumer doubleConsumer = (d) -> System.out.println("DoubleConsumer : " + d);
        doubleConsumer.accept(5);

        IntConsumer intConsumer = (i) -> System.out.println("IntConsumer : " + i);
        intConsumer.accept(10);

        LongConsumer longConsumer = (l) -> System.out.println("LongConsumer : " + l);
        longConsumer.accept(15);

        ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println(s + " = " + d);
        objDoubleConsumer.accept("This is ObjDoubleConsumer : ", 15);

        ObjIntConsumer<String> objIntConsumer = (s, i) -> System.out.println(s + " = " + i);
        objIntConsumer.accept("This is ObjIntConsumer : ", 20);

        ObjLongConsumer<String> objLongConsumer = (s, l) -> System.out.println(s + " = " + l);
        objLongConsumer.accept("This is ObjLongConsumer : ", 25);
    }
}
