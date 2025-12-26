package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private final Map<String, Map<String, Object>> users = new ConcurrentHashMap<>();
    private final AtomicLong userIdCounter = new AtomicLong(1);
    
    public Map<String, Object> registerUser(String fullName, String email, String encodedPassword, String role) {
        Long userId = userIdCounter.getAndIncrement();
        Map<String, Object> user = new HashMap<>();
        user.put("userId", userId);
        user.put("fullName", fullName);
        user.put("email", email);
        user.put("password", encodedPassword);
        user.put("role", role);
        
        users.put(email, user);
        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Map<String, Object> user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        
        Collection<GrantedAuthority> authorities = Collections.singletonList(
            new SimpleGrantedAuthority("ROLE_" + user.get("role"))
        );
        
        return new User(email, (String) user.get("password"), authorities);
    }
}