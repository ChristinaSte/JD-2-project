package com.itacademy.stetsko.database.entity;

import lombok.*;

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
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "admin", schema = "employee_storage")
public class Admin implements BaseEntity<Long> {
    @Id
    @Column(name = "employee_id", nullable = false)
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

    @Column(name = "position", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private UserPosition position;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Customer customer;
}
