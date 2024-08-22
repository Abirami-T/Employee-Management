package com.incture.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.employeeManagement.entities.Project;
import com.incture.employeeManagement.repositories.ProjectRepo;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
