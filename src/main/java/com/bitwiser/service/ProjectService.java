package com.bitwiser.service;

import com.bitwiser.entity.Project;
import com.bitwiser.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }



    public Project update(Long id, Project updatedProject) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        project.setTitle(updatedProject.getTitle());
        project.setDescription(updatedProject.getDescription());
        project.setImageUrl(updatedProject.getImageUrl());
        project.setProjectUrl(updatedProject.getProjectUrl());
        project.setTechnologies(updatedProject.getTechnologies());
        project.setFeatured(updatedProject.isFeatured());

        return projectRepository.save(project);
    }


    public Project getById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ProjectNot Found"));
    }
}