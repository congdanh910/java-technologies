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

import java.util.function.Function;

/*
    Function takes one T parameter and returns specific type R.
       Function<T, R> f = (t) -> { return r; }
 */
public class WhatIsFunction {

    public static void main (String[] args) {
        Function<Integer, String> f = i -> i.toString();

        System.out.println(f.apply(10));
    }
}