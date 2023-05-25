package com.mympms.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mympms.v1.entity.MobilePlan;
import com.mympms.v1.service.MobilePlanService;


@RestController
@RequestMapping("/mobile-plans")
public class MobilePlanController {
    private final MobilePlanService mobilePlanService;

    @Autowired
    public MobilePlanController(MobilePlanService mobilePlanService) {
        this.mobilePlanService = mobilePlanService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MobilePlan>> getAll() {
        return ResponseEntity.ok(
                mobilePlanService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MobilePlan>> getById(@PathVariable int mobilePlanId) {
        Optional<MobilePlan> plan = mobilePlanService.getOneById(mobilePlanId);

        if (plan.isPresent()) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
