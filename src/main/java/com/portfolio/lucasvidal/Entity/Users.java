/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Getter @Setter
@Entity

public class Users {
   @Id 
   @NotNull
   @Size(min = 1, max = 50, message = "no cumple la longitud")
   private String username;
   
   @NotNull
   @Size(min = 1, max = 50, message = "no cumple la longitud")
   private String password;
      
   @NotNull
   @Size(min = 1, max = 50, message = "no cumple la longitud")
   private String name;
         
   @NotNull
   @Size(min = 1, max = 50, message = "no cumple la longitud")
   private String surname;
            
   @Size(min = 1, max = 50, message = "no cumple la longitud")
   private String img;
    
    
}
