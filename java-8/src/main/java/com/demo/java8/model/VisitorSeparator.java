package com.demo.java8.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VisitorSeparator implements Consumer<Visitor> {

    private List<Visitor> vs1 = new ArrayList<Visitor>();
    private List<Visitor> vs2 = new ArrayList<Visitor>();


    @Override
    public void accept (Visitor visitor) {
        if ( Integer.valueOf(visitor.getId()) <= 500 ) {
            vs1.add(visitor);
        }
        else {
            vs2.add(visitor);
        }
    }

    public void combine (VisitorSeparator other) {
        this.vs1.addAll(other.vs1);
        this.vs2.addAll(other.vs2);
    }

    public List<Visitor> getVs1 () {
        return vs1;
    }

    public List<Visitor> getVs2 () {
        return vs2;
    }

}
