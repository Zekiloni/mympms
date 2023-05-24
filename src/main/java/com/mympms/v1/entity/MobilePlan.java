package com.mympms.v1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;



@Entity
@Table(name = "mobile_plans")
public class MobilePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int price;
    private Float discount;
    private LocalDateTime createdAt;

    public MobilePlan() {
    }

    public MobilePlan(String name, int price) {
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}