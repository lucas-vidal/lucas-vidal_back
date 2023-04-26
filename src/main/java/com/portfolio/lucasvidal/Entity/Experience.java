package com.portfolio.lucasvidal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    
    @Size(max = 100)
    private String link;


}
