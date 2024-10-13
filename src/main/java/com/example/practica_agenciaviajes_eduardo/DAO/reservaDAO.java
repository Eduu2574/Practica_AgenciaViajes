package com.example.practica_agenciaviajes_eduardo.DAO;

import java.sql.*;

public class reservaDAO {

    // Método para guardar una reserva
    public boolean guardarReserva(String destino, String medioTransporte, double precio) {
        String sql = "INSERT INTO reservas (destino, medioTransporte, precio) VALUES (?, ?, ?)";

        try (PreparedStatement ps = DataBaseManager.conectar().prepareStatement(sql)) {
            ps.setString(1, destino);
            ps.setString(2, medioTransporte);
            ps.setDouble(3, precio);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se insertó correctamente
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false; // Retorna false si hubo un error
        }
    }
}