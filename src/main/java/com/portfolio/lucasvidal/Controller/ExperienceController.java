/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Experience;
import com.portfolio.lucasvidal.Interface.IExperienceService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
    @RestController
public class ExperienceController {
    
    @Autowired IExperienceService iExperienceService;

        /* Devuelve lista de experiences */       
        @GetMapping("experience")
        public List<Experience> getExperiences(){
            return iExperienceService.getExperiences();
        }

        /* Devuelve un experiences */   
        @GetMapping("experience/{id}")
        public Experience findExperiences(@PathVariable Integer id){
            return iExperienceService.findExperienceById(id);
        }

        /* Crea experiences */       
        @PostMapping("experience")
        public String createExperience(@RequestBody Experience experience){
            iExperienceService.saveExperience(experience);
            return "Experience agregado";
        }

        /* Elimina experiences */       
        @DeleteMapping("/experience/{id}")
        public String deleteExperience(@PathVariable Integer id){
            iExperienceService.deleteExperienceById(id);
            return "Experience eliminado";
        }

        /* Actualiza experiences por URL */   
        @PutMapping("/experience1/{id}")
            public Experience updateExperienceUrl(@PathVariable Integer id,
                                                  @RequestParam("position") String newPosition,
                                                  @RequestParam("company") String newCompany,
                                                  @RequestParam("form") LocalDate newForm,
                                                  @RequestParam("until") LocalDate newUntil,
                                                  @RequestParam("description") String newDescription,
                                                  @RequestParam("link") String newLink){
                Experience experience = iExperienceService.findExperienceById(id);

                        experience.setPosition(newPosition); 
                        experience.setCompany(newCompany); 
                        experience.setForm(newForm); 
                        experience.setUntil(newUntil); 
                        experience.setDescription(newDescription); 
                        experience.setLink(newLink); 

                        iExperienceService.saveExperience(experience);
                        return experience;

            }

         /* Actualiza experiences por JSON */   
        @PutMapping("/experience/{id}")
            public Experience updateExperience(@PathVariable Integer id, @RequestBody Experience updatedExperiences) {
            Experience experience = iExperienceService.findExperienceById(id);

            if (experience != null) {
                // actualizar el experiences con los datos del objeto actualizado
                experience.setPosition(updatedExperiences.getPosition());
                experience.setCompany(updatedExperiences.getCompany());
                experience.setForm(updatedExperiences.getForm());
                experience.setUntil(updatedExperiences.getUntil());
                experience.setDescription(updatedExperiences.getDescription());
                experience.setLink(updatedExperiences.getLink());


                iExperienceService.saveExperience(experience);
            }

        return experience;
}
    
    
}
