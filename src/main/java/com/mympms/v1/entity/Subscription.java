package com.mympms.v1.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "mobile_plan_id")
    private MobilePlan mobilePlan;

    @Column(name = "starting_at")
    private LocalDate startingAt;

    @Column(name = "expiring_at")
    private LocalDate expiringAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime updatedAt;

    public Long getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
