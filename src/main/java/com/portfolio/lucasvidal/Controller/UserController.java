/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Users;
import com.portfolio.lucasvidal.Interface.IUserService;
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
@CrossOrigin(origins = {"http://localhost:4200/", "https://lucas-vidal-ap.web.app"})

public class UserController {
    @Autowired IUserService iUserService;

    /* Devuelve lista de Usuarios */       
    @GetMapping("users")
    public List<Users> getUser(){
        return iUserService.getUsers();
    }
    
    /* Devuelve un Usuario */   
    @GetMapping("users/{username}")
    public Users findUsers(@PathVariable String username){
        return iUserService.findUserByUsername(username);
    }
    
    /* Crea Usuario */       
    @PostMapping("users")
    public String createUser(@RequestBody Users users){
        iUserService.saveUser(users);
        return "Usuario agregado";
    }
    
    /* Elimina Usuario */       
    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username){
        iUserService.deleteUserByUsername(username);
        return "Usuario eliminado";
    }
    
    /* Actualiza Usuario por URL */   
    @PutMapping("/users1/{username}")
    public Users updateUserURL(@PathVariable String username,
                            @RequestParam("password") String newPassword,
                            @RequestParam("name") String newName,
                            @RequestParam("surname") String newSurname,
                            @RequestParam("title") String newTitle,
                            @RequestParam("skill1") String newSkill1,
                            @RequestParam("skill2") String newSkill2,
                            @RequestParam("skill3") String newSkill3,
                            @RequestParam("skill4") String newSkill4,
                            @RequestParam("linkedin") String newLinkedin,
                            @RequestParam("instagram") String newInstagram,
                            @RequestParam("facebook") String newFacebook,
                            @RequestParam("github") String newGithub,
                            @RequestParam("about") String newAbout,
                            @RequestParam("img") String newImg) {
        Users users = iUserService.findUserByUsername(username);

        users.setPassword(newPassword);
        users.setName(newName);
        users.setSurname(newSurname);
        users.setTitle(newTitle);
        users.setSkill1(newSkill1);
        users.setSkill2(newSkill2);
        users.setSkill3(newSkill3);
        users.setSkill4(newSkill4);
        users.setLinkedin(newLinkedin);
        users.setInstagram(newInstagram);
        users.setFacebook(newFacebook);
        users.setGithub(newGithub);
        users.setAbout(newAbout);
        users.setImg(newImg);

        iUserService.saveUser(users);
        return users;
    }

        
     /* Actualiza Usuario por JSON */   
    @PutMapping("/users/{username}")
        public Users updateUser(@PathVariable String username, @RequestBody Users updatedUser) {
        Users users = iUserService.findUserByUsername(username);

        if (users != null) {
            // actualizar el usuario con los datos del objeto actualizado

            users.setPassword(updatedUser.getPassword());
            users.setName(updatedUser.getName());
            users.setSurname(updatedUser.getSurname());
            users.setTitle(updatedUser.getTitle());
            users.setSkill1(updatedUser.getSkill1());
            users.setSkill2(updatedUser.getSkill2());
            users.setSkill3(updatedUser.getSkill3());
            users.setSkill4(updatedUser.getSkill4());
            users.setLinkedin(updatedUser.getLinkedin());
            users.setInstagram(updatedUser.getInstagram());
            users.setFacebook(updatedUser.getFacebook());
            users.setGithub(updatedUser.getGithub());
            users.setAbout(updatedUser.getAbout());
            users.setImg(updatedUser.getImg());


            iUserService.saveUser(users);
        }

    return users;
}


    
}
