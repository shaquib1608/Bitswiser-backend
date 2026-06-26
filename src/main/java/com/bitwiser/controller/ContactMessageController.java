package com.bitwiser.controller;

import com.bitwiser.entity.ContactMessage;
import com.bitwiser.service.ContactMessageService;
import com.bitwiser.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactMessageController {

    private final ContactMessageService service;
    private final EmailService emailService;

    public ContactMessageController(ContactMessageService service, EmailService emailService) {

        this.service = service;
        this.emailService = emailService;
    }

    @PostMapping
    public ContactMessage createMessage(@Valid @RequestBody ContactMessage message) {

        ContactMessage savedMessage = service.save(message);

//        // Email to you
//        emailService.sendEmail("sheikhfahad00786@gmail.com", "New Inquiry Received - BitWiser", "Name: " + message.getName() + "\nEmail: " + message.getEmail() + "\nSubject: " + message.getSubject() + "\n\nMessage:\n" + message.getMessage());
//
//        // Acknowledgement email to client
//        emailService.sendEmail(message.getEmail(), "Thank you for contacting BitWiser", "Hi " + message.getName() + ",\n\n" + "Thank you for reaching out to BitWiser.\n" + "We have received your inquiry and " + "will get back to you shortly.\n\n" + "Regards,\n" + "M D Shaquib Jahangir\n" + "Founder, BitWiser");

        return savedMessage;
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {

        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {

        service.delete(id);
    }
}