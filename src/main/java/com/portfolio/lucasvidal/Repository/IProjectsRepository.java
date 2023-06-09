/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.lucasvidal.Repository;

import com.portfolio.lucasvidal.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author lucas
 */
@Repository
public interface IProjectsRepository extends JpaRepository<Projects, Integer> {
 
}

