package com.textapp.cacheabledata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
public class CacheableDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheableDataApplication.class, args);
    }

}
