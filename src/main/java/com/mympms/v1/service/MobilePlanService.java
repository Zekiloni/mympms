package com.mympms.v1.service;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class MobilePlanService {

    public List<String> getAll() {
        return List.of("ee", "br");
    }
}
