package com.example.practica_agenciaviajes_eduardo.Controller;

import com.example.practica_agenciaviajes_eduardo.DAO.usuarioDAO;
import com.example.practica_agenciaviajes_eduardo.Domain.Usuario;
import com.example.practica_agenciaviajes_eduardo.Util.MostrarEscena;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class paginaPrincipalController {

    @FXML
    private PasswordField contrasenaTf;

    @FXML
    private Button iniciar;

    @FXML
    private Button registrar;

    @FXML
    private TextField usuarioTf;
    private usuarioDAO dao = new usuarioDAO();

    @FXML
    void onRegistrarClic() throws IOException {

        String nombreUsuario = usuarioTf.getText();
        String contrasena = contrasenaTf.getText();

        // Validar si los campos están vacíos
        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Debe ingresar usuario y contraseña");
            return; // Salir del método si los campos están vacíos
        }

        // Crear nuevo usuario con los datos proporcionados
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);

        // Crear una instancia del usuarioDAO
        usuarioDAO dao = new usuarioDAO();

        // Llamar al método crearUsuario
        int filasAfectadas = dao.crearUsuario(nuevoUsuario);

        // Verificar si el usuario se creó correctamente
        if (filasAfectadas > 0) {
            // Si se insertaron filas, mostrar un mensaje de éxito
            mostrarAlerta("Éxito", "Usuario registrado correctamente");
        } else {
            // Si no se insertaron filas, mostrar un mensaje de error
            mostrarAlerta("Error", "Hubo un problema al registrar el usuario");
        }
        //borramos los datos introducidos del Cliente
        usuarioTf.clear();
        contrasenaTf.clear();
    }

    @FXML
    public void onIniciarClic(ActionEvent event) throws IOException {
        String nombreUsuario = usuarioTf.getText();
        String contrasena = contrasenaTf.getText();
        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            // En el caso de que el usuario no introduzca alguno de los datos
            mostrarAlerta("Error", "Debe ingresar usuario y contraseña");
            return;
        }


        Usuario usuario = dao.obtenerUsuario(nombreUsuario, contrasena);

        if (usuario != null) {
            mostrarAlerta("Éxito", "Inicio de sesión exitoso");
            MostrarEscena.mostrarScene(event, "destino.fxml");
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}