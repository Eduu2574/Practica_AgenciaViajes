package com.example.practica_agenciaviajes_eduardo.DAO;

import com.example.practica_agenciaviajes_eduardo.Domain.Usuario;
import java.sql.*;

public class usuarioDAO {

    public int crearUsuario(Usuario usuario) {
        int filasAfectadas = 0;
        try (Connection con = DataBaseManager.conectar()) {
            String sql = "INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)";

            // Uso la conexión establecida previamente
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getContrasena());

            // Ejecuto la sentencia SQL y obtengo el número de filas afectadas
            filasAfectadas = sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return filasAfectadas;
    }
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = null;
        try (Connection con = DataBaseManager.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, contrasena);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                usuario = new Usuario(resultado.getString("nombre"), resultado.getString("contrasena"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
}