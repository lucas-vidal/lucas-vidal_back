/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.Education;
import com.portfolio.lucasvidal.Interface.IEducationService;
import com.portfolio.lucasvidal.Repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ImpEducationService implements IEducationService {
    
    @Autowired
    private IEducationRepository IEducationRepository;

    @Override
    public List<Education> getEducations() {
        List<Education> education = IEducationRepository.findAll();
        return education;
    }

    @Override
    public void saveEducation(Education education) {
        IEducationRepository.save(education);
    }

    @Override
    public void deleteEducationById(Integer id) {
        IEducationRepository.deleteById(id);
    }

    @Override
    public Education findEducationById(Integer id) {
        Education education = IEducationRepository.findById(id).orElse(null);
        return education;
        
    }
    
}
