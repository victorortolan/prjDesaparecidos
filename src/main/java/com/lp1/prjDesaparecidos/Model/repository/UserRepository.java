/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lp1.prjDesaparecidos.Model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp1.prjDesaparecidos.Model.entitys.User;

/**
 *
 * @author vitor
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
