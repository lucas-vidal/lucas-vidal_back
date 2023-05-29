/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Education;
import com.portfolio.lucasvidal.Interface.IEducationService;
import java.time.LocalDate;
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
    public class EducationController {
        @Autowired IEducationService iEducationService;

                /* Devuelve lista de educations */       
                @GetMapping("education")
                public List<Education> getEducations(){
                    return iEducationService.getEducations();
                }

                /* Devuelve un educations */   
                @GetMapping("education/{id}")
                public Education findEducations(@PathVariable Integer id){
                    return iEducationService.findEducationById(id);
                }

                /* Crea educations */       
                @PostMapping("education")
                public String createEducation(@RequestBody Education education){
                    iEducationService.saveEducation(education);
                    return "Education agregado";
                }

                /* Elimina educations */       
                @DeleteMapping("/education/{id}")
                public String deleteEducation(@PathVariable Integer id){
                    iEducationService.deleteEducationById(id);
                    return "Education eliminado";
                }
          
                /* Actualiza educations por URL */   
                @PutMapping("/education1/{id}")
                    public Education updateEducation1(@PathVariable Integer id,
                                                     @RequestParam("institute") String newInstitute,
                                                     @RequestParam("certificate") String newCertificate,
                                                     @RequestParam("form") LocalDate newForm,
                                                     @RequestParam("untils") LocalDate newUntil,
                                                     @RequestParam("state") String newState,
                                                     @RequestParam("link") String newLink){
                        Education education = iEducationService.findEducationById(id);

                                education.setInstitute(newInstitute);
                                education.setCertificate(newCertificate);
                                education.setForm(newForm);
                                education.setUntil(newUntil); 
                                education.setState(newState); 
                                education.setLink(newLink);

                                iEducationService.saveEducation(education);
                                return education;

                    }
                    
                    /* Actualiza educations por JSON */   
                   @PutMapping("/education/{id}")
                       public Education updateEducation(@PathVariable Integer id, 
                                                        @RequestBody Education updatedEducation) {
                       Education education = iEducationService.findEducationById(id);

                       if (education != null) {
                           // actualizar el educations con los datos del objeto actualizado
                           education.setInstitute(updatedEducation.getInstitute());
                           education.setCertificate(updatedEducation.getCertificate());
                           education.setForm(updatedEducation.getForm());
                           education.setUntil(updatedEducation.getUntil());
                           education.setState(updatedEducation.getState());
                           education.setLink(updatedEducation.getLink());

                           iEducationService.saveEducation(education);
                       }

                   return education;
               }
    }



