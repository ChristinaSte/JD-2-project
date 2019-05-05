package com.itacademy.service;

public class UserService {

    public static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    public User getDefaultUser() {
        return userDao.gerDefaultUser();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
