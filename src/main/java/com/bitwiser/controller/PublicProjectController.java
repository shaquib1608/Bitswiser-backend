package com.bitwiser.controller;

import com.bitwiser.entity.Project;
import com.bitwiser.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class PublicProjectController {

    private final ProjectService projectService;

    public PublicProjectController(
            ProjectService projectService) {

        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {

        return projectService.getAll();
    }
    @GetMapping("/{id}")
    public Project getProjectById(
            @PathVariable Long id){
        return projectService.getById(id);
    }


}