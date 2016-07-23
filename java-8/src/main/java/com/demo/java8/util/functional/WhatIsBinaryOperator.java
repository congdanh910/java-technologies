package com.demo.java8.util.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.demo.java8.model.Person;

/*
    BinaryOperator<T> bi = (t, t) -> { return t; };
    BinaryOperator<T> extends BiFunction<T, T, T> and return T
    BinaryOperator takes two parameters of the same type and process it and then returns results of the same type as parameters.
 */
public class WhatIsBinaryOperator {

    public static void main (String[] args) {
        BinaryOperator<String> s = (s1, s2) -> s1 + " " + s2;
        System.out.println(s.apply("Danh", "Ho"));
        System.out.println("---------------------------------------");

        Person p1 = new Person("001", "John", 20, "A");
        Person p2 = new Person("002", "Cansu", 23, "A");
        Person p3 = new Person("003", "Jack", 28, "B");
        Person p4 = new Person("004", "Tom", 18, "B");
        Person p5 = new Person("004", "David", 40, "C");

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);

        // Comparator to compare persons by age
        Comparator<Person> compByAge = Comparator.comparing(Person::getAge);

        //maxby
        Optional<Person> collect = persons.stream().collect(Collectors.maxBy(compByAge));
        System.out.println(collect);
        System.out.println("---------------------------------------");

        Map<String, Optional<Person>> reduce = persons.stream().collect(
            Collectors.groupingBy(
                Person::getClassName,
                Collectors.reducing(BinaryOperator.maxBy(compByAge)
                )
            ));
        reduce.forEach((key, value) -> System.out.println(key + " -- " + value));
        System.out.println("---------------------------------------");

        // minby

        Map<String, Optional<Person>> reduce2 = persons.stream().collect(
            Collectors.groupingBy(
                Person::getClassName,
                Collectors.reducing(BinaryOperator.minBy(compByAge)
                )
            ));
        reduce2.forEach((key, value) -> System.out.println(key + " -- " + value));
    }
}
