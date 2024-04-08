package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;

import java.net.URL;
import java.util.ResourceBundle;

public class OtController implements Initializable {

    @FXML
    private TextField txtEquipR;
    private GestorEmpleados gestorEmpleados;

    @FXML
    private TextArea txtFallaR;

    @FXML
    private TextArea txtFallaR1;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtHoraFin;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtTurno;

    @FXML
    private TextField txtUbiEquipo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setGestorEmpleados(GestorEmpleados gestorEmpleados){
        this.gestorEmpleados=gestorEmpleados;
    }

}
