package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.Skills;
import java.util.List;

public interface ISkillsService {
    //Traer una lista de habilidades
    public List<Skills> getSkills();
    
    //Guardar una habilidad
    public void saveSkill(Skills skills);
    
    //Eliminar una habilidad
    public void deleteSkillById(Integer id);
    
    //Buscar una habilidad por ID
    public Skills findSkillById(Integer id);
}
