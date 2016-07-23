package com.demo.java8.reduction;

import com.demo.java8.model.Visitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.OptionalInt;

/*
    JDK provides 2 reduction operations : reduce and collect
        Reduce operation returns a single value
        Collect operation returns the collection instead of the single value as reduce
 */
public class Reduction {

    public static String loadData(String path) {
        try {
            return IOUtils.toString(Reduction.class.getResourceAsStream(path), Charset.defaultCharset());
        } catch (IOException e) {
            return "";
        }
    }

    private static void utilsReduction(List<Visitor> visitors) {
        double average = visitors.stream().
                map(v -> Integer.valueOf(v.getId()))
                .mapToInt(id -> id)
                .average().getAsDouble();

        System.out.println("Average : " + average);

        int sum = visitors.stream().
                map(v -> Integer.valueOf(v.getId()))
                .mapToInt(id -> id)
                .sum();
        System.out.println("Sum : " + sum);

        OptionalInt max = visitors.stream().
                map(v -> Integer.valueOf(v.getId()))
                .mapToInt(id -> id)
                .max();
        System.out.println("Max : " + max.getAsInt());


        OptionalInt min = visitors.stream().
                map(v -> Integer.valueOf(v.getId()))
                .mapToInt(id -> id)
                .min();
        System.out.println("Min : " + min.getAsInt());

        long count = visitors.stream().
                map(v -> Integer.valueOf(v.getId()))
                .mapToInt(id -> id)
                .count();
        System.out.println("Count : " + count);
    }

    private static void reduceOperation(List<Visitor> visitors) {
        Integer integer = visitors.stream().map(v -> Integer.valueOf(v.getId())).reduce(
                0,
                (a, b) -> a + b
        );
        System.out.println("reduceOperation with identity = 0 : " + integer);


        Integer integer2 = visitors.stream().map(v -> Integer.valueOf(v.getId())).reduce(
                -5,
                (a, b) -> a + b
        );
        System.out.println("reduceOperation with identity = -5 : " + integer2);


        Integer integer3 = visitors.stream().map(v -> Integer.valueOf("-" + v.getId())).reduce(
                0,
                (a, b) -> a + b
        );
        System.out.println("reduceOperation with negative number and identity = 0 : " + integer3);

        Integer integer4 = visitors.stream().map(v -> Integer.valueOf("-" + v.getId())).reduce(
                -1,
                (a, b) -> a + b
        );
        System.out.println("reduceOperation with negative number and identity = -1 : " + integer4);


        visitors.clear();
        Integer integer5 = visitors.stream().map(v -> Integer.valueOf("-" + v.getId())).reduce(
                -1,
                (a, b) -> a + b
        );
        System.out.println("reduceOperation with empty stream : " + integer5); // return the default value, this is identity parameter
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        String dataLessThan1000 = Reduction.loadData("/mock-data.json");
        String dataGreaterThan1000 = Reduction.loadData("/mock-data-1000.json");

        List<Visitor> visitorsLessThan1000 = gson.fromJson(dataLessThan1000, new TypeToken<List<Visitor>>() {
        }.getType());
        List<Visitor> visitorsGreaterThan1000 = gson.fromJson(dataGreaterThan1000, new TypeToken<List<Visitor>>() {
        }.getType());

        /*
            Some useful reduce operations
         */

        utilsReduction(visitorsLessThan1000);


        /*
            Reduce operation
         */

        reduceOperation(visitorsLessThan1000);
    }

}
