package com.lp1.prjDesaparecidos.Controller;

import java.sql.Connection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp1.prjDesaparecidos.Model.Database;
import com.lp1.prjDesaparecidos.Model.User;
import com.lp1.prjDesaparecidos.Model.UserService;

@RestController
// @RequestMapping(path = "api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody User user) {

        User userCriado = userService.registerNewUser(user);
        if (userCriado instanceof User) { // ou == NULL
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário Criado com Sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno ao Criar Usuário!");
        }
    }

}