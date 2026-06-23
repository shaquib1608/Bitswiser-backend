
package com.bitwiser.controller;

import com.bitwiser.dto.LoginRequest;
import com.bitwiser.dto.LoginResponse;
import com.bitwiser.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/test")
    public String test() {
        return "BitWiser Backend Running";
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        String token =
                authService.login(request);

        return new LoginResponse(token);
    }
}