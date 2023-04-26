package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.Experience;
import java.util.List;

public interface IExperienceService {
    //Traer una lista de experiencias
    public List<Experience> getExperiences();
    
    //Guardar una experiencia
    public void saveExperience(Experience experience);
    
    //Eliminar una experiencia
    public void deleteExperienceById(Integer id);
    
    //Buscar una experiencia por ID
    public Experience findExperienceById(Integer id);
}
