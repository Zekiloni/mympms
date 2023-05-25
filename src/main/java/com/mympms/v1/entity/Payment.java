package com.mympms.v1.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "mobile_plan_id", nullable = false)
    private MobilePlan mobilePlan;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "is_refunded", columnDefinition = "boolean default false")
    private boolean refunded;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Payment() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MobilePlan getMobilePlan() {
        return mobilePlan;
    }

    public void setMobilePlan(MobilePlan mobilePlan) {
        this.mobilePlan = mobilePlan;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setPaymentDate(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}