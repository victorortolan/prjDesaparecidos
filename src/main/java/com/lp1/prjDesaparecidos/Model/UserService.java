/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lp1.prjDesaparecidos.Model;

import java.util.Optional;

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

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User registerNewUser(User user) {
        User usr = userRepository.findByEmail(user.getEmail());
        if (usr != null) {
            return null;
        }
        return userRepository.save(user);
    }

    public String login(LoginUser user) {
        User usr = userRepository.findByEmail(user.getEmail());

        if (usr.getPassword().equals(user.getPassword())) {
            return (usr.getId()).toString();
        }
        return "Nao Autorizado";

    }

}
