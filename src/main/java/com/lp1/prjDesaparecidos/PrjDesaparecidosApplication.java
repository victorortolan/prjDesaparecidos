package com.lp1.prjDesaparecidos;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lp1.prjDesaparecidos.Model.Database;

@SpringBootApplication
public class PrjDesaparecidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjDesaparecidosApplication.class, args);
		Connection con = Database.Conectar();
		if (con != null) {
			System.out.println("Deu certo.");
			System.out.println(con);
		}
	}

}
