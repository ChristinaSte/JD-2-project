package com.itacademy.stetsko.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements BaseEntity<Long> {

    @Override
    public Long getId() {
        return null;
    }
}
