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
    
    @GetMapping("users/all")
    public List<Users> getUser(){
        return iUserService.getUsers();
    }
    

    
    @PostMapping("users/add")
    public String createUser(@RequestBody Users users){
        iUserService.saveUser(users);
        return "Usuario agregado";
    }
    
    @DeleteMapping("/users/delete/{user}")
    public String deleteUser(@PathVariable String user){
        iUserService.deleteUser(user);
        return "Usuario eliminado";
    }
          
    @PutMapping("/users/update/{user}")
        public Users updateUser(@PathVariable String user,
                               @RequestParam("password") String newPassword,
                               @RequestParam("name") String newName,
                               @RequestParam("surname") String newSurname,
                               @RequestParam("img") String newImg){
            Users users = iUserService.findUser(user);
            
                    users.setPassword(newPassword);
                    users.setName(newName);
                    users.setSurname(newSurname);
                    users.setImg(newImg); 
                    
                    iUserService.saveUser(users);
                    return users;
                  
        }

    
}
