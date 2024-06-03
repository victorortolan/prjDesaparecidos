package com.lp1.prjDesaparecidos;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lp1.prjDesaparecidos.Model.Database;
import com.lp1.prjDesaparecidos.Model.User;
import com.lp1.prjDesaparecidos.Model.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class PrjDesaparecidosApplication {
    
        @Autowired
        private UserService userService; 

	public static void main(String[] args) {
		SpringApplication.run(PrjDesaparecidosApplication.class, args);
		Connection con = Database.Conectar();
		if (con != null) {
			System.out.println("Deu certo.");
			System.out.println(con);
		}
	}

        @PostConstruct
    public void init() {
        // Cria um novo usuário e salva no banco de dados
        User user = new User();
        user.setNome("Nome do Usuário");
        user.setEmail("example@example.com");

        userService.createUser(user);
    }
}
