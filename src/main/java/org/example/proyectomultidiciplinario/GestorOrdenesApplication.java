package org.example.proyectomultidiciplinario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.example.proyectomultidiciplinario.controller.*;
import org.example.proyectomultidiciplinario.models.Empleado;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GestorOrdenesApplication extends Application {
    private LoginEmpleadoController loginEmpleadoController = new LoginEmpleadoController();
    private LoginAdministradorController loginAdministradorController = new LoginAdministradorController();
    private RegistroEmpleadoController registroEmpleadoController = new RegistroEmpleadoController();
    private RegistroAdministradorController registroAdministradorController = new RegistroAdministradorController();
    private MenuController menuController = new MenuController();
    private ListaEmpleadosController listaEmpleadosController = new ListaEmpleadosController();
    private ListaEmpleadosComunesController listaEmpleadosComunesController = new ListaEmpleadosComunesController();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menuInicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MenuIncialController menuIncialController = fxmlLoader.getController();
        stage.setTitle("Gestor de empleados");
        stage.setScene(scene);
        stage.show();
        menuIncialController.initialize();
        listaEmpleadosComunesController.initialize();
        listaEmpleadosController.initialize();
        loginAdministradorController.initialize();
        loginEmpleadoController.initialize();
        registroAdministradorController.initialize();
        registroEmpleadoController.initialize();
        menuController.initialize();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();

    }

}