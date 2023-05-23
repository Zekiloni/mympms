package com.mympms.v1.entity;


import java.time.LocalDateTime;
import java.util.Currency;

public class MobilePlan {
    public Integer id;
    public String name;
    public int price;
    public Float discount;
    public LocalDateTime createdAt;

    public MobilePlan(String name, int price) {
        this.name = name;
        this.price = price;

        this.createdAt = LocalDateTime.now();
    }
}
