package com.mympms.v1.controller;

import com.mympms.v1.service.AppStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;


@RestController
@RequestMapping("/status")
public class AppStatusController {
    @Autowired
    private AppStatusService appStatusService;

    public static class AppStatusResponse {
        private final Duration uptime;
        private final String appVersion;

        public AppStatusResponse(Duration uptime, String version) {
            this.uptime = uptime;
            this.appVersion = version;
        }
    }

    @GetMapping
    public ResponseEntity<AppStatusResponse> getAppStatus() {
        return ResponseEntity.ok(new AppStatusResponse(
                appStatusService.getUptime(),
                appStatusService.getAppVersion()
        ));
    }
}
