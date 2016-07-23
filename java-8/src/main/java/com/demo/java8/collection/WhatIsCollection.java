package com.demo.java8.collection;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.demo.java8.model.Visitor;
import com.demo.java8.model.VisitorSeparator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WhatIsCollection {

    public static String loadData (String path) {
        try {
            return IOUtils.toString(WhatIsMap.class.getResourceAsStream(path), Charset.defaultCharset());
        }
        catch (IOException e) {
            return "";
        }
    }

    private static void listToObjectWhichContainsTwoSublist (List<Visitor> visitors) {
        VisitorSeparator separator = visitors.parallelStream().collect(
            VisitorSeparator::new,
            VisitorSeparator::accept,
            VisitorSeparator::combine
        );

        separator.getVs1().stream().mapToInt(v -> Integer.valueOf(v.getId())).
            forEach(id -> System.out.println("The first one : " + id)
            );
        System.out.println("---------------------------------------");
        separator.getVs2().stream().mapToInt(v -> Integer.valueOf(v.getId())).
            forEach(id -> System.out.println("The second one : " + id)
            );
    }

    public static void main (String[] args) {
        Gson gson = new Gson();
        String dataLessThan1000 = WhatIsMap.loadData("/mock-data.json");
        String dataGreaterThan1000 = WhatIsMap.loadData("/mock-data-1000.json");

        List<Visitor> visitorsLessThan1000 = gson.fromJson(dataLessThan1000, new TypeToken<List<Visitor>>() {
        }.getType());

        List<Visitor> visitorsGreaterThan1000 = gson.fromJson(dataGreaterThan1000, new TypeToken<List<Visitor>>() {
        }.getType());

        /*
            List to an Object which contains 2 sub-list of the first List
            For reference : https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html#reduce
         */

        listToObjectWhichContainsTwoSublist(visitorsLessThan1000);

    }

}
