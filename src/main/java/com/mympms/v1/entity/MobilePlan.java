package com.mympms.v1.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

import com.mympms.v1.enumeration.PlanType;


@Entity
@Table(name = "mobile_plans")
public class MobilePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobile_plan_id")
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    private PlanType type;

    @Column(nullable = false, columnDefinition = "FLOAT(3,2) DEFAULT 0.00")
    private Float discount;

    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "mobilePlan", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    public MobilePlan() {
    }

    public MobilePlan(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}