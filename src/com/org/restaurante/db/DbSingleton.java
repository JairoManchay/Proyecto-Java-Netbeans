package com.org.restaurante.db;

import java.sql.*;

public class DbSingleton {

    private static Connection cn = null;

    private String driver;
    private String url;
    private String user;
    private String password;

    private DbSingleton() {

        String url = "jdbc:mysql://localhost:3306/bd_restaurante";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "p0rt4m4ns0";

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a BD: " + e.getMessage());
        }
    }

    public static Connection getConnection() {

        if (cn == null) {
            new DbSingleton();
        }

        return cn;
    }
    
    public static void closeConnection() throws SQLException {
        try{
            cn.close();
            System.out.println("Conexion cerrada");
        } catch (Exception e) {
            System.out.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
}
