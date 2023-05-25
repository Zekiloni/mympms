package com.mympms.v1.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.mympms.v1.enumeration.UsageType;


@Entity
@Table(name = "usages")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "usage_type")
    private UsageType usageType;

    @Column(name = "usage_amount")
    private int usageAmount;

    @Column(name = "usage_date")
    private LocalDate usageDate;

    // Constructors, getters, setters, and other properties

    // Constructors
    public Usage() {
    }

    public Usage(Customer customer, UsageType usageType, int usageAmount, LocalDate usageDate) {
        this.customer = customer;
        this.usageType = usageType;
        this.usageAmount = usageAmount;
        this.usageDate = usageDate;
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

    public UsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public int getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(int usageAmount) {
        this.usageAmount = usageAmount;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }
}
