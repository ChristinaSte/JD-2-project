package com.itacademy.stetsko.database.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getId();
}