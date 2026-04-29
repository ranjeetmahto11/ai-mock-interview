package com.mockinterview.service;

import com.mockinterview.dto.request.LoginRequest;
import com.mockinterview.dto.request.RegisterRequest;
import com.mockinterview.dto.response.AuthResponse;
import com.mockinterview.entity.ExperienceLevel;
import com.mockinterview.entity.Role;
import com.mockinterview.entity.User;
import com.mockinterview.repository.UserRepository;
import com.mockinterview.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    // Register new user
    public AuthResponse register(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(
                    "Email already registered: " + request.getEmail());
        }

        // Build and save user
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .targetRole(request.getTargetRole())
                .experienceLevel(
                        request.getExperienceLevel() != null
                                ? ExperienceLevel.valueOf(
                                request.getExperienceLevel().toUpperCase())
                                : ExperienceLevel.FRESHER)
                .role(Role.USER)
                .build();

        userRepository.save(user);

        // Generate token
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(user.getEmail());
        String token = jwtUtil.generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .fullName(user.getFullName())
                .role(user.getRole().name())
                .message("Registration successful!")
                .build();
    }

    // Login existing user
    public AuthResponse login(LoginRequest request) {

        // Authenticate — throws exception if wrong credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Load user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Generate token
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(user.getEmail());
        String token = jwtUtil.generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .fullName(user.getFullName())
                .role(user.getRole().name())
                .message("Login successful!")
                .build();
    }
}