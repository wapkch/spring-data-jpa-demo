package com.example.springdatajpademo.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditorAware implements org.springframework.data.domain.AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("currentUser");
    }

}
