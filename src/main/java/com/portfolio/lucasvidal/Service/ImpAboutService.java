/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.About;
import com.portfolio.lucasvidal.Interface.IAboutService;
import com.portfolio.lucasvidal.Repository.IAboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImpAboutService implements IAboutService {
    @Autowired IAboutRepository iAboutRepository;

    @Override
    public List<About> getAbouts() {
        List<About> abouts = iAboutRepository.findAll();
        return abouts;
    }

    @Override
    public void saveAbout(About about) {
        iAboutRepository.save(about);
    }
    
    @Override
    public void deleteAboutById(Integer id) {
        iAboutRepository.deleteById(id);
    }
    
    @Override
    public About findAboutById(Integer id) {
        About about = iAboutRepository.findById(id).orElse(null);
        return about;
    }



 
    
}





