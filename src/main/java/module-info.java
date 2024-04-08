module org.example.proyectomultidiciplinario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.proyectomultidiciplinario to javafx.fxml;
    exports org.example.proyectomultidiciplinario;
    exports org.example.proyectomultidiciplinario.controller;
    opens org.example.proyectomultidiciplinario.controller to javafx.fxml;
}