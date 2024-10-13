package com.example.practica_agenciaviajes_eduardo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class facturaController {

    @FXML
    private Label nombreLabel;
    @FXML
    private Label destinoLabel;
    @FXML
    private Label transporteLabel;
    @FXML
    private Label precioLabel;

    // Método para inicializar los datos de la factura
    public void inicializar(String destino, String transporte, double precio) {

        // Muestro la información en las etiquetas
        destinoLabel.setText("Destino: " + destino);
        transporteLabel.setText("Medio de transporte: " + transporte);
        precioLabel.setText("Precio: " + precio+"€");
    }
}