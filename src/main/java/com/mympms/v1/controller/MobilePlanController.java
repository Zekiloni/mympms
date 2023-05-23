package com.mympms.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mobile-plans")
public class MobilePlanController {

    @GetMapping("/get-all")
    public ResponseEntity<List<String>> getAll() {
       return ResponseEntity.ok(List.of("ee", "cef"));
    }
}
