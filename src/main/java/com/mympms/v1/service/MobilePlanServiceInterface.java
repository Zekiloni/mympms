package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.MobilePlan;


public interface MobilePlanServiceInterface {
    void create(MobilePlan plan);
    void update(MobilePlan plan);
    void delete(MobilePlan plan);
    void deleteMany(List<MobilePlan> plans);
    List<MobilePlan> getAll();
    Optional<MobilePlan> getOneById(int id);

}
