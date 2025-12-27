package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private String secret;
    private long validity;

    // 🔥 constructor used in TESTS
    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    // ✅ REQUIRED BY TEST
    public Claims getAllClaims(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
}

    // 🔥 default constructor for Spring
    public JwtTokenProvider() {
        this.secret = "default-secret-key-default-secret-key"; // 32+ chars
        this.validity = 3600000; // 1 hour
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ✅ REQUIRED BY AuthController
    public String generateToken(Authentication authentication, Long userId, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validity);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY JwtAuthenticationFilter
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

    // ✅ REQUIRED BY JwtAuthenticationFilter
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


}
