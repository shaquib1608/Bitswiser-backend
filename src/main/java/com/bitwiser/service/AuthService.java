
package com.bitwiser.service;

import com.bitwiser.dto.LoginRequest;
import com.bitwiser.entity.AdminUser;
import com.bitwiser.repository.AdminUserRepository;
import com.bitwiser.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String login(LoginRequest request) {

        AdminUser user = repository.findByEmail(
                request.getEmail()
        ).orElseThrow(() ->
                new RuntimeException("Invalid Credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid Credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
