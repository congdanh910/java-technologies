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

package com.demo.java8.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import com.demo.java8.model.Node;

public class Tree {
    static List<Node> nodes;
    static int deep = 1;

    static {
        Node n1 = new Node("001", "Node 1");
        Node n2 = new Node("002", "Node 2", "001");
        Node n3 = new Node("003", "Node 3", "001");
        Node n4 = new Node("004", "Node 4", "002");
        Node n5 = new Node("005", "Node 5", "002");
        Node n6 = new Node("006", "Node 6", "005");

        Node no1 = new Node("No1", "Node No 1");
        Node no2 = new Node("No2", "Node No 2", "No1");
        Node no3 = new Node("No3", "Node No 3", "No1");
        Node no4 = new Node("No4", "Node No 4", "No3");
        Node no5 = new Node("No5", "Node No 5", "No1");
        Node no6 = new Node("No6", "Node No 6", "No2");

        Node c1 = new Node("c1", "Node C 1");
        Node c2 = new Node("c2", "Node C 2", "c1");
        Node c3 = new Node("c3", "Node C 3", "c1");
        Node c4 = new Node("c4", "Node C 4", "c3");
        Node c5 = new Node("c5", "Node C 5", "c1");
        Node c6 = new Node("c6", "Node C 6", "c2");

        nodes = Arrays.asList(n1, n2, n3, n4, n5, n6, no1, no2, no3, no4, no5, no6, c1, c2, c3, c4, c5, c6);
    }

    private static void print (Node node) {
        if ( node.getChildren().size() > 0 ) {
            node.getChildren().forEach(child -> {
                System.out.println("\t \t" + child + "\n");
                print(child);
            });
        }
        else {
            System.out.println("\t \t" + node + "\n");
        }
    }

    private static String tabGenerate (int num) {
        return IntStream.rangeClosed(0, num).mapToObj(j -> "\t").collect(Collectors.joining(" "));
    }

    public static void main (String[] args) {
        List<Node> notRoot = nodes.parallelStream().filter(n -> StringUtils.isNotBlank(n.getParentId())).collect(Collectors.toList());

        // Update children and parent
        notRoot.forEach(n -> {
            Node parent = nodes.stream().filter(p -> p.getId().equals(n.getParentId())).findFirst().get();
            if ( parent != null ) {
                n.setParentId(parent.getId());
                List<Node> child = parent.getChildren();
                child.add(n);
                parent.setChildren(child);
            }
        });

        List<Node> root = nodes.parallelStream().filter(n -> StringUtils.isBlank(n.getParentId())).collect(Collectors.toList());

        root.forEach(nr -> {
            System.out.println(nr + "\n");
            print(nr);
        });

    }
}
