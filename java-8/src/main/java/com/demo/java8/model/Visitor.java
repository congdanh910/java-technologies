package com.demo.java8.model;

import com.google.gson.annotations.SerializedName;

public class Visitor {
    private String id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String email;
    private String gender;
    @SerializedName("ip_address")
    private String ipAddress;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getIpAddress () {
        return ipAddress;
    }

    public void setIpAddress (String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString () {
        return "[ Visitor is " +
               "[Id = " + this.id + "], " +
               "[First name = " + this.firstName + "], " +
               "[Last name = " + this.lastName + "], " +
               "[Email = " + this.email + "], " +
               "[Gender = " + this.gender + "]" +
               "[Ip address = " + this.ipAddress + "]" +
               " ]";
    }

}
