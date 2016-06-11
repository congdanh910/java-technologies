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
