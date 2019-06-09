package com.itacademy.stetsko.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "orders", schema = "shop_storage")
public class Order implements BaseEntity<Long> {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_method", nullable = false, length = 128)
    @Enumerated(EnumType.STRING)
    private DeliveryMethod delivery;

    @Column(name = "payment_method", nullable = false, length = 64)
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment;

    @Column(name = "order_cost")
    private Double cost;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> order;
}
