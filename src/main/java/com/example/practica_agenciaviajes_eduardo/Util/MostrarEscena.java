package com.example.practica_agenciaviajes_eduardo.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.practica_agenciaviajes_eduardo.HelloApplication;

import java.io.IOException;

public class MostrarEscena {


    public static void mostrarScene(ActionEvent event, String archivoFxml) throws IOException {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(archivoFxml));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("AGENCIA DE VIAJES ");
        stage.setScene(scene);
        stageActual.close();
        stage.show();
    }
}
