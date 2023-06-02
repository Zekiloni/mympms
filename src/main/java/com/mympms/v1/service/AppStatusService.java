package com.mympms.v1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;


@Service
public class AppStatusService {
    @Value("${app.version}")
    private String appVersion;

    private final LocalDateTime startedAt;

    public AppStatusService() {
        this.startedAt = LocalDateTime.now();
    }

    public Duration getUptime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return Duration.between(this.startedAt, currentTime);
    }

    public String getAppVersion() {
        return this.appVersion;
    }
}
