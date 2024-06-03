/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lp1.prjDesaparecidos.Model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vitor
 */
public interface UserRepository extends JpaRepository<User,Long> {
    
}
