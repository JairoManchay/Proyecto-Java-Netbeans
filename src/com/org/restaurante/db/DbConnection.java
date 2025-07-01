package com.org.restaurante.db;

import java.sql.*;

public class DbConnection {

    private Connection cn = null;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String bd = "bd_restaurante";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    private final String user = "root";
    private final String password = "p0rt4m4ns0";

    public Connection getConnection() {

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a BD: " + e.getMessage());
        }

        return cn;
    }
}
