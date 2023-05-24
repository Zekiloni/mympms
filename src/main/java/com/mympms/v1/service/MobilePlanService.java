package com.mympms.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.MobilePlan;
import com.mympms.v1.repository.MobilePlanRepository;


@Service
public class MobilePlanService implements MobilePlanServiceInterface {
    @Autowired
    private MobilePlanRepository mobilePlanRepository;

    @Override
    public List<MobilePlan> getAll() {
        return mobilePlanRepository.findAll();
    }

    @Override
    public void create(MobilePlan plan) {
        mobilePlanRepository.save(plan);
    }

    @Override
    public Optional<MobilePlan> getOneById(int id) {
        return mobilePlanRepository.findById(id);
    }
}
