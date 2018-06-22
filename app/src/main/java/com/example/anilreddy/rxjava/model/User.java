package com.example.anilreddy.rxjava.model;

public class User {
    public long id;
    public String firstName;
    public String lastName;
    public boolean isFollowing;

    public User() {
    }

    public User(ApiUser apiUser) {
        this.id = apiUser.id;
        this.firstName = apiUser.firstName;
        this.lastName = apiUser.lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isFollowing=" + isFollowing +
                '}';
    }

    @Override
    public int hashCode() {
        return (int) (id + firstName.hashCode() + lastName.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;

            return this.id == user.id
                    && this.firstName.equals(user.firstName)
                    && this.lastName.equals(user.lastName);
        }
        return false;
    }
}
