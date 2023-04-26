/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.Projects;
import com.portfolio.lucasvidal.Interface.IProjectsService;
import com.portfolio.lucasvidal.Repository.IProjectsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ImpProjetsService implements IProjectsService {
    
    @Autowired
    private IProjectsRepository IProjectsRepository;

    @Override
    public List<Projects> getProjects() {
        List<Projects> projets = IProjectsRepository.findAll();
        return projets;
    }

    @Override
    public void saveProject(Projects project) {
        IProjectsRepository.save(project);
    }

    @Override
    public void deleteProjectById(Integer id) {
        IProjectsRepository.deleteById(id);
    }

    @Override
    public Projects findProjectById(Integer id) {
        Projects projects = IProjectsRepository.findById(id).orElse(null);
        return projects;
        
    }
    
}

