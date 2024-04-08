package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.example.proyectomultidiciplinario.models.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


    @FXML
    private TextField txtEquipR;
    private GestorEmpleados gestorEmpleados;

    @FXML
    private TextArea txtFallaE;

    @FXML
    private TextArea txtFallaR;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtHoraFin;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtUbiEquipo;
    private int folioContador = 0;


    private GestorOrdenes ot = new GestorOrdenes();

    GestorEmpleados empleadoDato = new GestorEmpleados();
    ArrayList<Empleado> lstEmpleado = empleadoDato.getListaEmpleado();




    }

    public void setGestorEmpleados(GestorEmpleados gestorEmpleados){
        this.gestorEmpleados=gestorEmpleados;
    }

}
