package com.demo.java8.util.functional;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import com.demo.java8.model.Item;
/*
    In Java 8, we have some special Supplier as BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier

    BooleanSupplier always return boolean value by the method getAsBoolean
    IntSupplier always return integer value by the method getAsInt
    LongSupplier always return long data type value by the method getAsLong
    DoubleSupplier always return double data type value by the method getAsDouble
 */
public class WhatIsTSupplier {

    public static void main (String[] args) {
        Item item = new Item(true, 123);
        BooleanSupplier bs = item::isStatus;

        System.out.println("Status:" + bs.getAsBoolean());

        IntSupplier is = item::getVal;
        System.out.println("Int Value:" + is.getAsInt());


        LongSupplier ls = item::getVal;
        System.out.println("Long Value:" + ls.getAsLong());

        DoubleSupplier ds = item::getVal;
        System.out.println("Double Value:" + ds.getAsDouble());
    }
}
