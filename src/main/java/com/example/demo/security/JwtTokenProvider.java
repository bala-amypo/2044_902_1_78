package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private String secret;
    private long validity;

    // used by tests
    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    // used by Spring
    public JwtTokenProvider() {
        this.secret = "default-secret-key-default-secret-key"; // 32+ chars
        this.validity = 3600000;
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // 🔥 THIS METHOD IS THE FIX
    public String generateToken(Authentication authentication, Long userId, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validity);

        String username = authentication.getName();

        return Jwts.builder()
                .setSubject(username)
                .claim("username", username)   // ✅ TEST EXPECTS THIS
                .claim("email", username)      // ✅ EXTRA SAFETY
                .claim("userId", userId)        // ✅ TEST EXPECTS THIS
                .claim("role", role)            // ✅ TEST EXPECTS THIS
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    public Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
