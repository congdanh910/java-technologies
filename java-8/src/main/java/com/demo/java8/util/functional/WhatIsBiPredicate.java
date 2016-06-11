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

import java.util.function.BiPredicate;

/*
    BiPredicate<T, U> bi = (t,u) -> { return boolean; };
    BiPredicate takes 2 parameters and return boolean type.
    The function method is test(Object, Object).
 */
public class WhatIsBiPredicate {

    public static void main (String[] args) {
        BiPredicate<String, String> biPredicate = (s1, s2) -> {
            if ( s1.startsWith(s2) ) {
                return true;
            }
            return false;
        };

        System.out.println(biPredicate.test("Hello Danh Ho", "Hello"));

        BiPredicate<String, String> biPredicate2 = (s1, s2) -> {
            if ( s1.endsWith(s2) ) {
                return true;
            }
            return false;
        };

        System.out.println(biPredicate.or(biPredicate2).test("Hello Danh Ho", "aaa"));
        System.out.println(biPredicate.and(biPredicate2).test("Ho Hello Danh Ho", "Ho"));
    }
}
