package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private String secret;
    private long validity;

    // 🔥 REQUIRED BY TEST
    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    // 🔥 REQUIRED BY SPRING
    public JwtTokenProvider() {
    }
}
