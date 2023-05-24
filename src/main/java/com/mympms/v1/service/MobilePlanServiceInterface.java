package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.MobilePlan;


public interface MobilePlanServiceInterface {
    List<MobilePlan> getAll();
    void create(MobilePlan plan);
    Optional<MobilePlan> getOneById(int id);
}
