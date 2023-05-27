package com.mympms.v1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoggerUtilComponent {
    private final Logger logger;

    public LoggerUtilComponent() {
        this.logger = LoggerFactory.getLogger(LoggerUtilComponent.class);
    }
    public void info(String message) {
        logger.info(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
