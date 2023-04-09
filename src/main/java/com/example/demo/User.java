package com.example.demo;

public record User(String firstName, String lastName) {
    public static User of(String firstName, String lastName) {
        return new User(firstName, lastName);
    }
}
