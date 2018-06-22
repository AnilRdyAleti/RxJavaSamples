package com.example.anilreddy.rxjava.model;

public class ApiUser {
    public long id;
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        return "ApiUser{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
