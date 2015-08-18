package com.mockito.demo.model;

import java.util.Date;

/**
 * Created by CongDanh on 7/8/15.
 */
public class Staff {
    private String firstName;
    private String lastName;
    private String address;
    private Date birthday;
    private Date startDate;
    private Date createDate;

    public Staff() {
    }

    public Staff(String firstName, String lastName, String address, Date birthday, Date startDate, Date createDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.startDate = startDate;
        this.createDate = createDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
