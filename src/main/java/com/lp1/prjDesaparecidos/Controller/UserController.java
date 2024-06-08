package com.lp1.prjDesaparecidos.Controller;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp1.prjDesaparecidos.Model.database.Database;
import com.lp1.prjDesaparecidos.Model.entitys.User;
import com.lp1.prjDesaparecidos.Model.services.UserService;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/status")
    public ResponseEntity<String> status() {

        Connection con = Database.Conectar();
        if (con != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deu Certo.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deu Errado.");
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody User user) {
        User userCriado = userService.registerNewUser(user);
        if (userCriado instanceof User) { // ou == NULL
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário Criado com Sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno ao Criar Usuário!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String responseText = userService.login(user);
        if (responseText.equals("Nao Autorizado")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não Autorizado");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Login feito para o usuário de id : " + responseText + " .\n");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserData(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"nome\":\"" + user.getNome() + "\",\"email\": \"" + user.getEmail() + "\"}");
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deletado.";
    }

}