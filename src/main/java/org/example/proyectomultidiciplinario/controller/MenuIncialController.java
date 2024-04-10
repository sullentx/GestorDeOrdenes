package org.example.proyectomultidiciplinario.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;

import java.io.IOException;
import java.util.ArrayList;



public class MenuIncialController  {

    private int cuentasLogeadas;
    private ArrayList<Empleado>listaEmpleado = new ArrayList<>();
    private ArrayList<Empleado>listaAdmin = new ArrayList<>();
    private ArrayList<Departamento>lstDepa = new ArrayList<>();



    @FXML
    void bntIREmpleado(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("loginEmpleado.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de Empleados");
            LoginEmpleadoController loginEmpleadoController= fxmlLoader.getController();
            loginEmpleadoController.setListaEmpleado(listaEmpleado);
            loginEmpleadoController.setListaAdmin(listaAdmin);
            loginEmpleadoController.setCuentasLogeadas(cuentasLogeadas);
            loginEmpleadoController.setLstDepa(lstDepa);
            loginEmpleadoController.initialize();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    @FXML
    void bntIrAdmin(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("loginAdministrador.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de Empleados");
            LoginAdministradorController loginAdministradorController= fxmlLoader.getController();
            loginAdministradorController.setListaAdmin(listaAdmin);
            loginAdministradorController.setListaEmpleado(listaEmpleado);
            loginAdministradorController.setCuentasLogeadas(cuentasLogeadas);
            loginAdministradorController.setLstDepa(lstDepa);
            loginAdministradorController.initialize();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }
    @FXML
    void btnNavegador(MouseEvent event) {
        String url = "https://esab.com/mx/nam_es/";
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el navegador.", ButtonType.OK);
            alert.showAndWait();
        }
    }



    public void initialize() {
        this.listaAdmin = listaAdmin;
        this.listaEmpleado = listaEmpleado;
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
    public void setLstDepa(ArrayList<Departamento> lstDepa) {
        this.lstDepa = lstDepa;
    }
}