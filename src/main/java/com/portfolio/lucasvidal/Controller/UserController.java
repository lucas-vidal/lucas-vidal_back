/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Controller;

import com.portfolio.lucasvidal.Entity.Users;
import com.portfolio.lucasvidal.Interface.IUserService;
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
        public Users updateUser(@PathVariable String username,
                               @RequestParam("password") String newPassword,
                               @RequestParam("name") String newName,
                               @RequestParam("surname") String newSurname,
                               @RequestParam("img") String newImg){
            Users users = iUserService.findUserByUsername(username);
            
                    users.setPassword(newPassword);
                    users.setName(newName);
                    users.setSurname(newSurname);
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
            users.setImg(updatedUser.getImg());

            iUserService.saveUser(users);
        }

    return users;
}


    
}
