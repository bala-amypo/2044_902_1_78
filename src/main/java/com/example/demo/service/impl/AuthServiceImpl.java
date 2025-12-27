package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                          CustomUserDetailsService userDetailsService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public AuthResponse authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        // For simplicity, we'll use a mock user lookup
        Map<String, Object> user = Map.of(
            "userId", 1L,
            "role", "VOLUNTEER"
        );
        
        String token = jwtTokenProvider.generateToken(authentication, 
            (Long) user.get("userId"), (String) user.get("role"));
        
        return new AuthResponse(token, (Long) user.get("userId"), (String) user.get("role"));
    }
    
    @Override
    public AuthResponse register(RegisterRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        
        Map<String, Object> user = userDetailsService.registerUser(
            request.getFullName(),
            request.getEmail(),
            encodedPassword,
            request.getRole() != null ? request.getRole() : "VOLUNTEER"
        );
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            request.getEmail(), request.getPassword()
        );
        
        String token = jwtTokenProvider.generateToken(authentication,
            (Long) user.get("userId"), (String) user.get("role"));
        
        return new AuthResponse(token, (Long) user.get("userId"), (String) user.get("role"));
    }
}