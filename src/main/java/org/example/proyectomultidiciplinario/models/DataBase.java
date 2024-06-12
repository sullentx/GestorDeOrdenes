package org.example.proyectomultidiciplinario.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/prueba";
    private static final String USER = "root";
    private static final String PASSWORD = "chatitodiaz117";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
