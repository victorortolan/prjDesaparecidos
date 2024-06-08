package com.lp1.prjDesaparecidos.Model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prjDes", "vitor", "12345678");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro no acesso ao banco de dados.");
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

}
