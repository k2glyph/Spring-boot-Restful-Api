package com.example.model;



/**
 * Created by dinesh on 6/20/2016.
 */
public class Student{

    private int id;
    private String firstname;
    private String lastname;
    private Address address;

    public Student() {
    }

    public Student(int id, String firstname, String lastname,Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
