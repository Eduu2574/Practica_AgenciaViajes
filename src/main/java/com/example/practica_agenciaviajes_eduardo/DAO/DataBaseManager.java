package com.example.practica_agenciaviajes_eduardo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CLASE PARA REALIZAR LA CONEXIÓN A LA BASE DE DATOS

public class DataBaseManager {


    public static Connection conectar() throws SQLException {

        //defino la URL de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/agencia_viajes";

        //especifico el nombre de usuario y contraseña para acceder a la base de datos
        String username = "root";
        String password = "IESRibera23";

        //establezco la conexión a la base de datos utilizando DriverManager
        Connection connection = DriverManager.getConnection(url, username, password);

        //devuelvo la conexión
        return connection;
    }
}