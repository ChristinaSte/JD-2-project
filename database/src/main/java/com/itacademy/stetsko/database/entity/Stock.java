package com.itacademy.stetsko.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stock implements BaseEntity<Long> {

    @Override
    public Long getId() {
        return null;
    }
}
