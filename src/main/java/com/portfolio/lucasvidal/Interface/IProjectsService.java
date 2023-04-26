package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.Projects;
import java.util.List;

public interface IProjectsService {
    //Traer una lista de proyectos
    public List<Projects> getProjects();
    
    //Guardar un proyecto
    public void saveProject(Projects projects);
    
    //Eliminar un proyecto
    public void deleteProjectById(Integer id);
    
    //Buscar un proyecto por ID
    public Projects findProjectById(Integer id);
}
