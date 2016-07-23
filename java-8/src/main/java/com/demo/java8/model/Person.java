package com.demo.java8.model;

public class Person {

    private String id;
    private String name;
    private int    age;
    private String className;

    public Person (String id, String name, int age, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public Person () {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getClassName () {
        return className;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    @Override
    public String toString () {
        return "[ Person is " +
               "[Id = " + this.id + "], " +
               "[Name = " + this.name + "], " +
               "[Age = " + this.age + "], " +
               "[Class = " + this.className + "]" +
               " ]";
    }
}
