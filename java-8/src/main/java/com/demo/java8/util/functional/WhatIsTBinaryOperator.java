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

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
/*
    DoubleBinaryOperator takes 2 double parameters and return double data type. The method is applyAsDouble
        DoubleBinaryOperator d = (d1, d2) -> return d3;

    IntBinaryOperator takes 2 integer parameters and return integer data type. The method is applyAsInt
        IntBinaryOperator i = (i1, i2) -> return i3;

    LongBinaryOperator takes 2 long parameters and return long data type. The method is applyAsLong
        LongBinaryOperator l = (l1, l2) -> return l3;
 */

public class WhatIsTBinaryOperator {

    public static void main (String[] args) {

        DoubleBinaryOperator doubleBinaryOperator = (d1, d2) -> d1 * d2;
        System.out.println(doubleBinaryOperator.applyAsDouble(2, 2));

        IntBinaryOperator intBinaryOperator = (i1, i2) -> i1 * i2;
        System.out.println(intBinaryOperator.applyAsInt(2, 3));

        LongBinaryOperator longBinaryOperator = (l1, l2) -> l1 * l2;
        System.out.println(longBinaryOperator.applyAsLong(4, 5));
    }
}
