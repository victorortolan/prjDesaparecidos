/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lp1.prjDesaparecidos.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitor
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user){
        return userRepository.save(user);
    }
    
}
