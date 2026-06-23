
package com.bitwiser.service;

import com.bitwiser.entity.AdminUser;
import com.bitwiser.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final AdminUserRepository repository;

    public AdminUser findByEmail(String email) {
        return repository.findByEmail(email)
                .orElse(null);
    }
}