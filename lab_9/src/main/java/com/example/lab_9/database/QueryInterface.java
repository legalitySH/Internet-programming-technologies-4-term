package com.example.lab_9.database;

public interface QueryInterface {
    boolean isHasUser(User user);
    void createUser(User user);

    String getUserRole(User user);
}
