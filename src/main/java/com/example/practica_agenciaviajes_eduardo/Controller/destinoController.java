package com.example.practica_agenciaviajes_eduardo.Controller;

import com.example.practica_agenciaviajes_eduardo.DAO.reservaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class destinoController {

    @FXML
    private RadioButton romaRadioBtn;

    @FXML
    private RadioButton parisRadioBtn;

    @FXML
    private RadioButton londresRadioBtn;

    @FXML
    private ComboBox<String> medioTransporteCb;

    @FXML
    private Text facturaText;

    @FXML
    private ToggleGroup destino;


    // Método para inicializar los datos
    @FXML
    public void initialize() {
        medioTransporteCb.getItems().addAll("Avión", "Tren", "Bus");
        medioTransporteCb.getSelectionModel();  // Selecciona la primera opción por defecto
    }

    // Método que calcula el precio dependiendo del destino y el medio de transporte
    private double calcularPrecio(String destino, String transporte) {
        double precio = 0.0;

        // Precio por destino y medio de transporte
        if (destino.equals("Roma")) {
            if (transporte.equals("Avión")) {
                precio = 500.0;
            } else if (transporte.equals("Tren")) {
                precio = 300.0;
            } else if (transporte.equals("Bus")) {
                precio = 150.0;
            }
        } else if (destino.equals("París")) {
            if (transporte.equals("Avión")) {
                precio = 400.0;
            } else if (transporte.equals("Tren")) {
                precio = 250.0;
            } else if (transporte.equals("Bus")) {
                precio = 130.0;
            }
        } else if (destino.equals("Londres")) {
            if (transporte.equals("Avión")) {
                precio = 450.0;
            } else if (transporte.equals("Tren")) {
                precio = 275.0;
            } else if (transporte.equals("Bus")) {
                precio = 160.0;
            }
        }
        return precio;
    }

    // Método para cuando se hace clic en "Comprar"
    @FXML
    public void onComprarClic(ActionEvent event) throws IOException {
        // Obtener destino seleccionado
        String destinoSeleccionado = "";
        if (romaRadioBtn.isSelected()) {
            destinoSeleccionado = "Roma";
        } else if (parisRadioBtn.isSelected()) {
            destinoSeleccionado = "París";
        } else if (londresRadioBtn.isSelected()) {
            destinoSeleccionado = "Londres";
        }

        // Obtener medio de transporte seleccionado
        String transporte = medioTransporteCb.getSelectionModel().getSelectedItem();

        // Comprobar que se haya seleccionado destino y medio de transporte
        if (destinoSeleccionado.isEmpty() || transporte == null) {
            mostrarAlerta("Error", "Por favor, selecciona un destino y un medio de transporte.");
            return;
        }

        // Calcular el precio
        double precio = calcularPrecio(destinoSeleccionado, transporte);

        // Guardar la reserva en la base de datos
        reservaDAO reservaDAO = new reservaDAO(); // Conexión a la base de datos
        boolean exito = reservaDAO.guardarReserva(destinoSeleccionado, transporte, precio);

        if (exito) {
            mostrarAlerta("Compra Realizada", "Tu reserva se ha realizado con éxito!\n" +
                    "Te redirigmos a la pagina para consultar tu factura-->");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/practica_agenciaviajes_eduardo/factura.fxml"));
            Parent root = loader.load();
            facturaController facturaCtrl = loader.getController();
            facturaCtrl.inicializar(destinoSeleccionado, transporte, precio);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {
            mostrarAlerta("Error", "Hubo un error al realizar la reserva. Intenta nuevamente.");
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}