package com.itacademy.stetsko.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "orders")
@Entity
@Table(name = "customer_storage")
public class Customer implements BaseEntity<Long>{

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 12)
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "phone_number", nullable = false, length = 12, unique = true)
    private String phoneNumber;

    @Column(name = "mail", nullable = false, length = 128, unique = true)
    private String mail;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;
}

