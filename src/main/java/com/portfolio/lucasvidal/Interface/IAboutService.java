package com.portfolio.lucasvidal.Interface;

import com.portfolio.lucasvidal.Entity.About;
import java.util.List;

/**
 *
 * Interfaz para la gestión de la entidad About
 */
public interface IAboutService {
    
    //
    public List<About> getAbouts();
    
    //
    public void saveAbout(About about);
    
    //
    public void deleteAboutById(Integer id);
    
    //
    public About findAboutById(Integer id);
}
