package com.portfolio.lucasvidal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    private String position;
    
    @NotNull
    private String company;
    
    @NotNull
    private LocalDate form;
    
    private LocalDate until;
    
    @NotNull
    private String description;
    
    @Size(max = 255, message = "no cumple la longitud")
    private String img; 
    
    @Size(max = 255)
    private String link;


}
