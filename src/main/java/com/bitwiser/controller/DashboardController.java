package com.bitwiser.controller;

import com.bitwiser.entity.ContactMessage;
import com.bitwiser.entity.Project;
import com.bitwiser.repository.ContactMessageRepository;
import com.bitwiser.repository.ProjectRepository;
import com.bitwiser.repository.ServiceRepository;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    private final ProjectRepository projectRepository;
    private final ServiceRepository serviceRepository;
    private final ContactMessageRepository contactRepository;
    public DashboardController(
            ProjectRepository projectRepository,
            ServiceRepository serviceRepository,
            ContactMessageRepository contactRepository) {
        this.projectRepository = projectRepository;
        this.serviceRepository = serviceRepository;
        this.contactRepository = contactRepository;
    }
    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put(
                "projects",
                projectRepository.count()
        );
        stats.put(
                "services",
                serviceRepository.count()
        );
        stats.put(
                "inquiries",
                contactRepository.count()
        );
        return stats;
    }
    @GetMapping("/recent-inquiries")
    public List<ContactMessage> getRecentInquiries() {
        return contactRepository
                .findAll()
                .stream()
                .sorted((a, b) ->
                        b.getCreatedAt()
                                .compareTo(a.getCreatedAt()))
                .limit(5)
                .toList();
    }
    @GetMapping("/recent-projects")
    public List<Project> getRecentProjects() {
        return projectRepository
                .findAll()
                .stream()
                .sorted((a, b) ->
                        b.getId()
                                .compareTo(a.getId()))
                .limit(5)
                .toList();
    }

}