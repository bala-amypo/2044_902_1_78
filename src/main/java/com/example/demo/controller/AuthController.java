package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(AuthenticationManager authenticationManager,
                         CustomUserDetailsService userDetailsService,
                         JwtTokenProvider jwtTokenProvider,
                         PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
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
        
        AuthResponse response = new AuthResponse(token, (Long) user.get("userId"), (String) user.get("role"));
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        Map<String, Object> user = Map.of(
            "userId", 1L,
            "role", "VOLUNTEER"
        );
        
        String token = jwtTokenProvider.generateToken(authentication, 
            (Long) user.get("userId"), (String) user.get("role"));
        
        AuthResponse response = new AuthResponse(token, (Long) user.get("userId"), (String) user.get("role"));
        return ResponseEntity.ok(response);
    }
}