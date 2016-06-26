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

package com.demo.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String     id;
    private String     name;
    private String     parentId;
    private List<Node> children;
    private int        deep;

    public Node () {
    }

    public Node (String id, String name) {
        this(id, name, null, null);
    }

    public Node (String id, String name, String parentId) {
        this(id, name, parentId, null);
    }

    public Node (String id, String name, String parentId, List<Node> children) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = children;
    }

    public String getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getParentId () {
        return parentId;
    }

    public void setParentId (String parentId) {
        this.parentId = parentId;
    }

    public List<Node> getChildren () {
        return children == null ? new ArrayList<>() : children;
    }

    public void setChildren (List<Node> children) {
        this.children = children;
    }

    public int getDeep () {
        return deep;
    }

    public void setDeep (int deep) {
        this.deep = deep;
    }

    @Override
    public String toString () {
        return "[ Node is " +
               "[Id = " + this.id + "], " +
               "[Name = " + this.name + "], " +
               "[ParentId = " + this.parentId + "], " +
               "[Children = " + ((this.children != null) ? this.children.size() : 0) + "]" +
               " ]";
    }
}