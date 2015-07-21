package com.demo.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danh.ho on 21/07/2015.
 */
@XmlRootElement(name = "classes")
public class MyClass {
    private long id;
    private String name;
    private List<Student> students = new ArrayList<Student>();
    private Date createDate = new Date();

    public MyClass() {
    }

    public MyClass(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @XmlElementWrapper
    @XmlElement(name = "student")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Date getCreateDate() {
        return createDate;
    }

    @XmlElement(name = "create_date")
    @XmlJavaTypeAdapter(DateFormat.class)
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return this.id +", " + this.name + ", size : " + this.students.size() + ", create_date : " + this.createDate;
    }
}
