package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;


public class MenuController {

    @FXML
    private AnchorPane achListaEmpleado;

    @FXML
    private AnchorPane anchDeparamento;
    @FXML
    private AnchorPane achListaEmpleado1;


    @FXML
    private AnchorPane anchGraficaDatos;
    private ArrayList<Empleado> listaAdmin;
    private ArrayList<Empleado>listaEmpleado;
    private int cuentasLogeadas;

    public void ocultarForEmpleado(){
        anchDeparamento.setDisable(true);
        achListaEmpleado.setDisable(true);
        anchGraficaDatos.setDisable(true);
        achListaEmpleado1.setDisable(true);
    }


    @FXML
    void bntGraficaDatos(MouseEvent event) {

    }

    @FXML
    void btnCerrarSesion(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menuInicial.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            MenuIncialController menuIncialController = fxmlLoader.getController();
            menuIncialController.setListaEmpleado(listaEmpleado);
            menuIncialController.setListaAdmin(listaAdmin);
            menuIncialController.setCuentasLogeadas(cuentasLogeadas);
            menuIncialController.initialize();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    @FXML
    void btnCrearOt(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("ot-view.fxml"));
        try {

            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de usuarios");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnListaDepartamento(MouseEvent event) {

    }

    @FXML
    void btnListaAdministradores(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("listaEmpleados-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de usuarios");
            ListaEmpleadosController listaEmpleadosController =fxmlLoader.getController();
            listaEmpleadosController.setListaAdmin(listaAdmin);
            listaEmpleadosController.setListaEmpleado(listaEmpleado);
            listaEmpleadosController.setCuentasLogeadas(cuentasLogeadas);
            listaEmpleadosController.initialize();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    @FXML
    void btnVerListaOT(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("listOT-view.fxml"));
        try {
            listOTController listOTController = fxmlLoader.getController();

            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Lista de OT");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    }

}

