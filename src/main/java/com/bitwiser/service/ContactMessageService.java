package com.bitwiser.service;

import com.bitwiser.entity.ContactMessage;
import com.bitwiser.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(
            ContactMessageRepository repository) {

        this.repository = repository;
    }

    public ContactMessage save(ContactMessage message) {

        message.setCreatedAt(LocalDateTime.now());

        return repository.save(message);
    }

    public List<ContactMessage> getAll() {

        return repository.findAll();
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }
}