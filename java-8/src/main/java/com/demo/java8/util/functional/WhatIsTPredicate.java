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
