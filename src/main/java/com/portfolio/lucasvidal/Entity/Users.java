/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lucasvidal.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
   @Size(max = 50, message = "no cumple la longitud")
   private String username;
   
   @NotNull
   @Size(max = 50, message = "no cumple la longitud")
   private String password;
      
   @NotNull
   @Size(max = 50, message = "no cumple la longitud")
   private String name;
         
   @NotNull
   @Size(max = 50, message = "no cumple la longitud")
   private String surname;
   
   @NotNull
   @Size(max = 100, message = "no cumple la longitud")
   private String title;
   
   @NotNull
   @Size(max = 100, message = "no cumple la longitud")
   private String skill1;
      
   @Size(max = 100, message = "no cumple la longitud")
   private String skill2;
         
   @Size(max = 100, message = "no cumple la longitud")
   private String skill3;
            
   @Size(max = 100, message = "no cumple la longitud")
   private String skill4;
               
   @Size(max = 100, message = "no cumple la longitud")
   private String linkedin;
   
   @Size(max = 100, message = "no cumple la longitud")
   private String instagram;
      
   @Size(max = 100, message = "no cumple la longitud")
   private String facebook;
         
   @Size(max = 100, message = "no cumple la longitud")
   private String github;
   
   @NotNull
   @Size(max = 5000, message = "no cumple la longitud")
   private String about;
   
   @NotNull
   @Size(max = 255, message = "no cumple la longitud")
   private String img; 
}
