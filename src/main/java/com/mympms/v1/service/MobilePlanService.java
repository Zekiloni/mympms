package com.mympms.v1.service;

import java.util.List;

import com.mympms.v1.entity.MobilePlan;
import org.springframework.stereotype.Service;


@Service
public class MobilePlanService {

    public List<MobilePlan> getAll() {
        return List.of(
            new MobilePlan("Test", 23),
            new MobilePlan("Second", 35)
        );
    }
}
