package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;

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
