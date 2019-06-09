package com.itacademy.stetsko.service;

import com.itacademy.stetsko.database.dao.UserDao;
import com.itacademy.stetsko.database.entity.User;
import lombok.Getter;

@Getter
public class UserService {

    public static final UserService INSTANCE = new UserService( );
    private final UserDao userDao = UserDao.getInstance( );

}
