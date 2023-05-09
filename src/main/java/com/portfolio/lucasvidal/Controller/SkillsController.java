/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Skills;
import com.portfolio.lucasvidal.Interface.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin(origins = {"http://localhost:4200", "https://lucas-vidal-ap.web.app"})
    
    public class SkillsController {
   @Autowired ISkillsService iSkillsService;

        /* Devuelve lista de skillss */       
        @GetMapping("skills")
        public List<Skills> getSkills(){
            return iSkillsService.getSkills();
        }

        /* Devuelve un skills */   
        @GetMapping("skills/{id}")
        public Skills findSkills(@PathVariable Integer id){
            return iSkillsService.findSkillById(id);
        }

        /* Crea skills */       
        @PostMapping("skills")
        public String createSkills(@RequestBody Skills skills){
            iSkillsService.saveSkill(skills);
            return "Skills agregado";
        }

        /* Elimina skills */       
        @DeleteMapping("/skills/{id}")
        public String deleteSkills(@PathVariable Integer id){
            iSkillsService.deleteSkillById(id);
            return "Skills eliminado";
        }

        /* Actualiza skills por URL */   
        @PutMapping("/skills1/{id}")
            public Skills updateSkillsUrl(@PathVariable Integer id,
                                          @RequestParam("skill") String newSkill,
                                          @RequestParam("value") Integer newValue){
                Skills skills = iSkillsService.findSkillById(id);

                        skills.setSkill(newSkill); 
                        skills.setValue(newValue); 

                        iSkillsService.saveSkill(skills);
                        return skills;

            }

         /* Actualiza skills por JSON */   
        @PutMapping("/skills/{id}")
            public Skills updateSkills(@PathVariable Integer id, @RequestBody Skills updatedSkills) {
            Skills skills = iSkillsService.findSkillById(id);

            if (skills != null) {
                // actualizar el skills con los datos del objeto actualizado
                skills.setSkill(updatedSkills.getSkill());
                skills.setValue(updatedSkills.getValue());


                iSkillsService.saveSkill(skills);
            }

        return skills;
    } 
}
