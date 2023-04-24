/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.Users;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface IUserService {
    //Traer una lista users
    public List<Users> getUsers();
    
    //Guardar un usuario
    public void saveUser(Users users);
    
    //Eliminar usuario
    public void deleteUser(String user);
    
    //Buscar un usuario por ID
    public Users findUser(String user);


}
