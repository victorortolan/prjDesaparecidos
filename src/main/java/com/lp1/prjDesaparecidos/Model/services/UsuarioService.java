/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lp1.prjDesaparecidos.Model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp1.prjDesaparecidos.Model.entitys.User;
import com.lp1.prjDesaparecidos.Model.repository.UsuarioRepository;

/**
 *
 * @author vitor
 */

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public User registerNewUser(User user) {
        User usr = userRepository.findByEmail(user.getEmail());
        if (usr != null) {
            return null;
        }
        return userRepository.save(user);
    }

    public String login(User user) {
        User usr = userRepository.findByEmail(user.getEmail());

        if (usr.getPassword().equals(user.getPassword())) {
            return (usr.getId()).toString();
        }
        return "Nao Autorizado";

    }

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
