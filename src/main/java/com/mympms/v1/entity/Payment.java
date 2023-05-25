package com.mympms.v1.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.mympms.v1.enumeration.PaymentStatus;


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

    @Column(name = "payment_status")
    private PaymentStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Payment() {
        this.status = PaymentStatus.PENDING;
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

    public PaymentStatus getStatus() {
        return this.status;
    }

    public void setRefunded() {
        this.status = PaymentStatus.REFUNDED;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setPaymentDate(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}