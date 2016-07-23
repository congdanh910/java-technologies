package com.demo.java8.collection;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.demo.java8.model.Visitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WhatIsMap {

    public static String loadData (String path) {
        try {
            return IOUtils.toString(WhatIsMap.class.getResourceAsStream(path), Charset.defaultCharset());
        }
        catch (IOException e) {
            return "";
        }
    }

    public static void compareParallelAndNot (List<Visitor> visitors) {
        long a = System.currentTimeMillis();
        Map<String, Visitor> visitorMap = visitors.stream().collect(
            Collectors.toMap(
                Visitor::getId,
                v -> v
            )
        );
        System.out.println("With stream  = " + (System.currentTimeMillis() - a));

        long b = System.currentTimeMillis();
        Map<String, Visitor> visitorMap2 = visitors.parallelStream().collect(
            Collectors.toMap(
                Visitor::getId,
                v -> v
            )
        );
        System.out.println("With stream parallel = " + (System.currentTimeMillis() - b));
    }

    public static Map<String, Visitor> listToMap (List<Visitor> visitors) {
        return visitors.parallelStream().collect(Collectors.toMap(Visitor::getId, v -> v));
    }

    public static void mapAndFilterEx (Map<String, Visitor> map) {
        Integer id = map.entrySet().stream().
            filter(en -> en.getKey().equals("1")).
            mapToInt(en -> Integer.valueOf(en.getKey())).
            findFirst().
            getAsInt();

        String id2 = map.entrySet().stream().
            filter(en -> Integer.valueOf(en.getKey()) > 900).
            map(e -> e.getKey()).
            collect(Collectors.joining(", "));

        System.out.println("id = " + id + ", id2 = " + id2);
    }

    public static void merge2MapsEx (Map<String, Visitor> map1, Map<String, Visitor> map2) {
        map2.entrySet().forEach(en -> {
            map1.merge(en.getKey(), en.getValue(), (v1, v2) -> {
                System.out.println(v1.getId() + "----------" + v2.getId());
                return null;
            });
        });
    }

    public static void computeEx (Map<String, Visitor> map) {
        System.out.println("------compute (k must exist in the map)--------");
        map.compute("1", (k, v) -> {
                        System.out.println(k + ", " + v);
                        v.setEmail("congdanh910@gmail.com");
                        return v;
                    }
        );
        System.out.println("------compute (k must exist in the map)--------\n");

        System.out.println("------computeIfPresent (k NO need to exist in the map)--------");
        map.computeIfPresent("-1", (k, v) -> {
                                 System.out.println(k + ", " + v);
                                 v.setEmail("congdanh910@gmail.com");
                                 return v;
                             }
        );
        System.out.println("------computeIfPresent (k NO need to exist in the map)--------");

        System.out.println("------computeIfAbsent--------");
        map.computeIfAbsent("-1", (k) -> {
                                System.out.println(k);
                                Visitor v = new Visitor();
                                v.setId(k);
                                return v;
                            }
        );
        System.out.println("Get the key absent = " + map.get("-1"));
        System.out.println("------computeIfAbsent--------");
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
            Compare speed between stream and parallel stream
         */
        //compareParallelAndNot(visitors);

        /*
            To Map<String, Visitor> ~ Map<{VisitorId}, {Visitor}>
         */
        Map<String, Visitor> mapLessThan1000 = listToMap(visitorsLessThan1000);
        Map<String, Visitor> mapGreaterThan1000 = listToMap(visitorsGreaterThan1000);

        /*
            Example about map and filter of Map Api
         */
        // mapAndFilterEx(mapLessThan1000);


        /*
            Example about merge between 2 Maps to one
         */
        // merge2MapsEx(mapLessThan1000, mapGreaterThan1000);
        // System.out.println(mapLessThan1000.size());

        /*
            Example compute* method
         */

        // computeEx(mapLessThan1000);


        /*
            Transfer list to list(list1, list2)
         */


    }
}
