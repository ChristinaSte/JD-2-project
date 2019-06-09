package com.itacademy.stetsko.database.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    public static final UserDao INSTANCE = new UserDao( );

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
