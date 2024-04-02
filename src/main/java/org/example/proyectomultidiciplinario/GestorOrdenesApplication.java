package org.example.proyectomultidiciplinario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.controller.LoginController;
import org.example.proyectomultidiciplinario.controller.RegistrarUsuariosController;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;

import java.io.IOException;

public class GestorOrdenesApplication extends Application {
    private GestorEmpleados gestorEmpleados;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginController loginController = fxmlLoader.getController();
        loginController.setGestorEmpleados(gestorEmpleados);
        stage.setTitle("Gestor de empleados");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}