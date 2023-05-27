package com.mympms.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.MobilePlan;
import com.mympms.v1.repository.MobilePlanRepository;


@Service
public class MobilePlanService implements BaseServiceInterface<MobilePlan> {
    @Autowired
    private MobilePlanRepository mobilePlanRepository;

    @Override
    public MobilePlan create(MobilePlan plan) {
        return mobilePlanRepository.save(plan);
    }

    @Override
    public void update(MobilePlan plan) {
        mobilePlanRepository.save(plan);
    }

    @Override
    public void delete(MobilePlan plan) {
        mobilePlanRepository.delete(plan);
    }

    @Override
    public void deleteMany(List<MobilePlan> plans) {
        mobilePlanRepository.deleteAll(plans);
    }

    @Override
    public List<MobilePlan> getAll() {
        return mobilePlanRepository.findAll();
    }

    @Override
    public Optional<MobilePlan> getOneById(int id) {
        return mobilePlanRepository.findById(id);
    }
}
