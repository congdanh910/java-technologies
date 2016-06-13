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
