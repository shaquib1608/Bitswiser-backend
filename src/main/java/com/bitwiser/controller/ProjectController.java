package com.bitwiser.controller;

import com.bitwiser.entity.Project;
import com.bitwiser.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(
            @RequestBody Project project) {
        System.out.println("Received Project: " + project);



        return projectService.save(project);
    }


    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @RequestBody Project project) {

        return projectService.update(id, project);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteProject(
            @PathVariable Long id) {

        projectService.delete(id);

        return "Project Deleted";
    }
}