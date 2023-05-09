/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Projects;
import com.portfolio.lucasvidal.Interface.IProjectsService;
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
    
    public class ProjectsController {
    @Autowired IProjectsService iProjectsService;

        /* Devuelve lista de projectss */       
        @GetMapping("projects")
        public List<Projects> getProjects(){
            return iProjectsService.getProjects();
        }

        /* Devuelve un Project */   
        @GetMapping("projects/{id}")
        public Projects findProjectss(@PathVariable Integer id){
            return iProjectsService.findProjectById(id);
        }

        /* Crea Project */       
        @PostMapping("projects")
        public String createProjects(@RequestBody Projects projects){
            iProjectsService.saveProject(projects);
            return "Project agregado";
        }

        /* Elimina Project */       
        @DeleteMapping("/projects/{id}")
        public String deleteProjects(@PathVariable Integer id){
            iProjectsService.deleteProjectById(id);
            return "Project eliminado";
        }

        /* Actualiza Project por URL */   
        @PutMapping("/projects1/{id}")
            public Projects updateProjectsUrl(@PathVariable Integer id,
                                                  @RequestParam("title") String newTitle,
                                                  @RequestParam("description") String newDescription,
                                                  @RequestParam("link") String newLink,
                                                  @RequestParam("img") String newImg){
                Projects projects = iProjectsService.findProjectById(id);

                        projects.setTitle(newTitle); 
                        projects.setDescription(newDescription); 
                        projects.setLink(newLink); 
                        projects.setImg(newImg);
                        
                        iProjectsService.saveProject(projects);
                        return projects;

            }

         /* Actualiza Project por JSON */   
        @PutMapping("/projects/{id}")
            public Projects updateProjects(@PathVariable Integer id, @RequestBody Projects updatedProjectss) {
            Projects projects = iProjectsService.findProjectById(id);

            if (projects != null) {
                // actualizar el Project con los datos del objeto actualizado
                projects.setTitle(updatedProjectss.getTitle());
                projects.setDescription(updatedProjectss.getDescription());
                projects.setLink(updatedProjectss.getLink());
                projects.setImg(updatedProjectss.getImg());


                iProjectsService.saveProject(projects);
            }

        return projects;
}
    
}
