package com.mympms.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;


@Service
public class AppStatusService {
    private final LocalDateTime startedAt;

    public AppStatusService() {
        this.startedAt = LocalDateTime.now();
    }

    public Duration getUptime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return Duration.between(this.startedAt, currentTime);
    }
}
