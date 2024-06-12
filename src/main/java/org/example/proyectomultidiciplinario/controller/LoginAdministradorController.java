package org.example.proyectomultidiciplinario.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;



import java.io.IOException;

import java.util.ArrayList;


public class LoginAdministradorController {
    @FXML
    private TextField txtNombreUser;

    @FXML
    private TextField txtPassword;
    private ArrayList<Empleado> listaAdmin;
    private ArrayList<Empleado> listaEmpleado;

    private Stage stage = new Stage();
    private int cuentasLogeadas;

    private ArrayList<Departamento>lstDepa;


    public void btnAgregarUsers(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("registroAdministrador.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de Empleados");
            RegistroAdministradorController registroAdministradorController = fxmlLoader.getController();
            registroAdministradorController.setListaAdmin(listaAdmin);
            registroAdministradorController.setListaEmpleado(listaEmpleado);
            registroAdministradorController.setCuentasLogeadas(cuentasLogeadas);
            registroAdministradorController.setLstDepa(lstDepa);
            registroAdministradorController.initialize();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }


    public void btnIniciarSesion(MouseEvent event) {
        initialize();
        if (listaAdmin.isEmpty()||txtNombreUser.getText().isEmpty()||txtPassword.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Lista vacia o campos vacios");
            alerta.setContentText("Registrar usuarios para poder ingresar");
            alerta.showAndWait();
        }else {
            int cuentasLogeadas = 0;
            boolean usuarioValido = false;
            for (Empleado empleado: listaAdmin){
                if (empleado.getNombreUser().equals(txtNombreUser.getText())&&empleado.getPassword().equals(txtPassword.getText())){
                    usuarioValido = true;
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
                    try {
                        Pane root = fxmlLoader.load();
                        Scene scene= new Scene(root);
                        stage.setTitle("Menu principal");
                        MenuController menuController = fxmlLoader.getController();
                        menuController.setListaAdmin(listaAdmin);
                        menuController.setListaEmpleado(listaEmpleado);
                        menuController.setLstDepa(lstDepa);
                        menuController.setCuentasLogeadas(cuentasLogeadas);
                        menuController.initialize();
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Node source = (Node) event.getSource();
                    stage = (Stage) source.getScene().getWindow();stage.close();
                }
                cuentasLogeadas++;
            }
            if (!usuarioValido) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Error al inicar sesion");
                alerta.setContentText("Contraseña o usuario incorrecto");
                alerta.showAndWait();
            }
        }


    }

    public void initialize() {
        this.listaAdmin = listaAdmin;
        this.listaEmpleado = listaEmpleado;
        this.lstDepa = lstDepa;
        //txtNombreUser.setStyle("-fx-text-fill: red;");
    }
    public void setLstDepa(ArrayList<Departamento> lstDepa) {
        this.lstDepa = lstDepa;
    }
    public void setCuentasLogeadas(int cuentasLogeadas) {
        this.cuentasLogeadas = cuentasLogeadas;
    }
    public void setListaAdmin(ArrayList<Empleado> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }
    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
}
