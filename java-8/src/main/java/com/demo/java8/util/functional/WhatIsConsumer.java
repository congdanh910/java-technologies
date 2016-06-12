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

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.demo.java8.model.Person;

/*
    Consumer<T> cons = (t) -> {};
    Consumer takes one parameter and return void.
    We can use for the terminal operations. Something likes println or calculate
    This one usually uses for some methods as peek(), foreach(), foreachOrdered().
    The function method is accept(Object)
*/
public class WhatIsConsumer {

    public static void main (String[] args) {
        Person p1 = new Person("001", "John", 20, "A");
        Person p2 = new Person("002", "Cansu", 23, "A");
        Person p3 = new Person("003", "Jack", 28, "B");
        Person p4 = new Person("004", "Tom", 18, "B");
        Person p5 = new Person("004", "David", 40, "C");

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);

        Consumer<Person> printPerson = person -> System.out.println(person);

        persons.forEach(printPerson);
    }
}
