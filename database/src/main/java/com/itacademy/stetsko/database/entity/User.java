package com.itacademy.stetsko.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "user", schema = "shop_storage", catalog = "shop_repository")
public class User implements BaseEntity<Long>{

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false, length = 64, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "role", nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private UserPosition role;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Customer customer;

}
