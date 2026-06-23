package com.bitwiser.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_messages")
@Data
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String subject;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime createdAt;
}