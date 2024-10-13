module com.example.practica_agenciaviajes_eduardo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.practica_agenciaviajes_eduardo to javafx.fxml;
    opens com.example.practica_agenciaviajes_eduardo.Controller to javafx.fxml;

    exports com.example.practica_agenciaviajes_eduardo;
    exports com.example.practica_agenciaviajes_eduardo.Controller;
}
