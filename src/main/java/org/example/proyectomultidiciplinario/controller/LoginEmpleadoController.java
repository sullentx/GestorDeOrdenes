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


public class LoginEmpleadoController {
    private ArrayList<Empleado>listaEmpleado;
    private ArrayList<Empleado>listaAdmin;

    @FXML
    private TextField txtNombreUser;

    @FXML
    private TextField txtPassword;
    private Alert alerta = new Alert(Alert.AlertType.ERROR);
    private Stage stage = new Stage();
    private int cuentasLogeadas;

    private ArrayList<Departamento>lstDepa;



    public void btnAgregarUsers(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("registroEmpleado.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de Empleados");
            RegistroEmpleadoController registroEmpleadoController = fxmlLoader.getController();
            registroEmpleadoController.setListaEmpleado(listaEmpleado);
            registroEmpleadoController.setListaAdmin(listaAdmin);
            registroEmpleadoController.setCuentasLogeadas(cuentasLogeadas);
            registroEmpleadoController.setLstDepa(lstDepa);
            registroEmpleadoController.initialize();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    public void btnIniciarSesion(MouseEvent event){
        if (listaEmpleado.isEmpty()||txtNombreUser.getText().isEmpty()||txtPassword.getText().isEmpty()){
            alerta.setTitle("Error");
            alerta.setHeaderText("Lista vacia o campos vacios");
            alerta.setContentText("Registrar usuarios para poder ingresar");
            alerta.showAndWait();
        }else {
            int cuentasLogeadas = 0;
            boolean usuarioValido= false;
            for (Empleado empleado: listaEmpleado){
                if (empleado.getNombreUser().equals(txtNombreUser.getText())&&empleado.getPassword().equals(txtPassword.getText())){
                    usuarioValido = true;
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
                    try {
                        Pane root = fxmlLoader.load();
                        Scene scene= new Scene(root);
                        stage.setTitle("Menu principal");
                        MenuController menuController = fxmlLoader.getController();
                        menuController.setListaEmpleado(listaEmpleado);
                        menuController.setListaAdmin(listaAdmin);
                        menuController.setLstDepa(lstDepa);
                        menuController.initialize();
                        menuController.setCuentasLogeadas(cuentasLogeadas);
                        menuController.initialize();
                        menuController.ocultarForEmpleado();
                        menuController.setEmpleado(listaEmpleado.get(cuentasLogeadas));
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
    }
    public void setLstDepa(ArrayList<Departamento> lstDepa) {
        this.lstDepa = lstDepa;
    }
    public void setCuentasLogeadas(int cuentasLogeadas) {
        this.cuentasLogeadas = cuentasLogeadas;
    }
    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
    public void setListaAdmin(ArrayList<Empleado> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }

}
