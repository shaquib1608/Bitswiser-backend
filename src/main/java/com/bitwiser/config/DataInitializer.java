package com.bitwiser.config;

import com.bitwiser.entity.AdminUser;
import com.bitwiser.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AdminUserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {

        if(repository.findByEmail("admin@bitwiser.in").isEmpty()) {

            AdminUser admin = AdminUser.builder()
                    .name("Md Shaquib")
                    .email("admin@bitwiser.in")
                    .password(encoder.encode("Admin123"))
                    .build();

            repository.save(admin);

            System.out.println("Admin Created");
        }
    }
}