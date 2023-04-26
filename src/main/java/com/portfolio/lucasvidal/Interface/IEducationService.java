package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.Education;
import java.util.List;

public interface IEducationService {
    //Traer una lista de educaciones
    public List<Education> getEducations();
    
    //Guardar una educacion
    public void saveEducation(Education education);
    
    //Eliminar una educacion
    public void deleteEducationById(Integer id);
    
    //Buscar una educacion por ID
    public Education findEducationById(Integer id);
}
