/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.About;
import com.portfolio.lucasvidal.Interface.IAboutService;
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
    public class AboutController {
        @Autowired IAboutService iAboutService;

        /* Devuelve lista de abouts */       
        @GetMapping("about")
        public List<About> getAbouts(){
            return iAboutService.getAbouts();
        }

        /* Devuelve un about */   
        @GetMapping("about/{id}")
        public About findAbouts(@PathVariable Integer id){
            return iAboutService.findAboutById(id);
        }

        /* Crea about */       
        @PostMapping("about")
        public String createAbout(@RequestBody About about){
            iAboutService.saveAbout(about);
            return "About agregado";
        }

        /* Elimina about */       
        @DeleteMapping("/about/{id}")
        public String deleteAbout(@PathVariable Integer id){
            iAboutService.deleteAboutById(id);
            return "About eliminado";
        }

        /* Actualiza about por URL */   
        @PutMapping("/about1/{id}")
            public About updateAboutUrl(@PathVariable Integer id,
                                   @RequestParam("about") String newAbout){
                About about = iAboutService.findAboutById(id);


                        about.setAbout(newAbout); 

                        iAboutService.saveAbout(about);
                        return about;

            }

         /* Actualiza about por JSON */   
        @PutMapping("/about/{id}")
            public About updateAbout(@PathVariable Integer id, @RequestBody About updatedAbout) {
            About about = iAboutService.findAboutById(id);

            if (about != null) {
                // actualizar el about con los datos del objeto actualizado
                about.setAbout(updatedAbout.getAbout());

                iAboutService.saveAbout(about);
            }

        return about;
}
    
}

