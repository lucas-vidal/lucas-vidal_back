/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.Experience;
import com.portfolio.lucasvidal.Interface.IExperienceService;
import com.portfolio.lucasvidal.Repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ImpExperienceService implements IExperienceService {

    @Autowired
    private IExperienceRepository IExperienceRepository;

    @Override
    public List<Experience> getExperiences() {
        List<Experience> experience = IExperienceRepository.findAll();
        return experience;
    }

    @Override
    public void saveExperience(Experience experience) {
        IExperienceRepository.save(experience);
    }

    @Override
    public void deleteExperienceById(Integer id) {
        IExperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperienceById(Integer id) {
        Experience experience = IExperienceRepository.findById(id).orElse(null);
        return experience;
        
    }

}
