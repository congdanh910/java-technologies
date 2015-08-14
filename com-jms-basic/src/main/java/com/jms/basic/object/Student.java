package com.jms.basic.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CongDanh on 8/14/15.
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private String address;
    private Date birthday;

    public Student() {
    }

    public Student(String id, String name, String address, Date birthday) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "id : " + this.id + ", name : " + this.name + ", address : " + this.address;
    }
}
