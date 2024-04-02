package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;

import java.io.IOException;

public class MenuController {
    private GestorEmpleados gestorEmpleados;

    @FXML
    private Button bntGraficaDatos;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnCrearOt;

    @FXML
    private Button btnListaDepartamento;

    @FXML
    private Button btnListaEmpleados;

    @FXML
    private Button btnVerListaOT;

    @FXML
    private Label lbMostrarUser;
    @FXML
    private AnchorPane achListaEmpleado;

    @FXML
    private AnchorPane anchDeparamento;

    @FXML
    private AnchorPane anchGraficaDatos;

   //Logea Empleado, desabilitar Anchor pane de grafica de datos y lista de empleados
    public void ocultarForEmpleado(){
        anchDeparamento.setDisable(true);
        achListaEmpleado.setDisable(true);
        anchGraficaDatos.setDisable(true);
    }


    @FXML
    void bntGraficaDatos(MouseEvent event) {

    }

    @FXML
    void btnCerrarSesion(MouseEvent event) {

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
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    @FXML
    void btnListaDepartamento(MouseEvent event) {

    }

    @FXML
    void btnListaEmpleados(MouseEvent event) {

    }

    @FXML
    void btnVerListaOT(MouseEvent event) {

    }







    public void setGestorEmpleados(GestorEmpleados gestorEmpleados){
        this.gestorEmpleados=gestorEmpleados;
    }
}
