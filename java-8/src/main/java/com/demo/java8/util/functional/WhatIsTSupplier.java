////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 * Copyright © 2016 Unified Social, Inc.
 * 180 Madison Avenue, 23rd Floor, New York, NY 10016, U.S.A.
 * All rights reserved.
 *
 * This software (the "Software") is provided pursuant to the license agreement you entered into with Unified Social,
 * Inc. (the "License Agreement").  The Software is the confidential and proprietary information of Unified Social,
 * Inc., and you shall use it only in accordance with the terms and conditions of the License Agreement.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND "AS AVAILABLE."  UNIFIED SOCIAL, INC. MAKES NO WARRANTIES OF ANY KIND, WHETHER
 * EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO THE IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
