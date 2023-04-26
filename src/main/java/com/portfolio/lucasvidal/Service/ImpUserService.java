/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Service;

import com.portfolio.lucasvidal.Entity.Users;
import com.portfolio.lucasvidal.Interface.IUserService;
import com.portfolio.lucasvidal.Repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ImpUserService implements IUserService{
    @Autowired IUserRepository iUserRepository;
    
    @Override
    public List<Users> getUsers() {
        List<Users> users = iUserRepository.findAll();
        return users;
    }

    @Override
    public void saveUser(Users users) {
        iUserRepository.save(users);
    }

    @Override
    public void deleteUserByUsername(String username) {
        iUserRepository.deleteById(username);
    }

    @Override
    public Users findUserByUsername(String username) {
        Users users = iUserRepository.findById(username).orElse(null);
        return users;
    }


    
}
