/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.Skills;
import com.portfolio.lucasvidal.Interface.ISkillsService;
import com.portfolio.lucasvidal.Repository.ISkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ImpSkillsService implements ISkillsService {
    
    @Autowired
    private ISkillsRepository ISkillsRepository;

    @Override
    public List<Skills> getSkills() {
        List<Skills> skills = ISkillsRepository.findAll();
        return skills;
    }

    @Override
    public void saveSkill(Skills skills) {
        ISkillsRepository.save(skills);
    }

    @Override
    public void deleteSkillById(Integer id) {
        ISkillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkillById(Integer id) {
        Skills Skills = ISkillsRepository.findById(id).orElse(null);
        return Skills;
        
    }
    
}

