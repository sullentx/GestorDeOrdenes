package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.example.proyectomultidiciplinario.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.proyectomultidiciplinario.models.OrdenDeTrabajo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OtController implements Initializable {

    @FXML
    private ComboBox<String> cmbxEM;

    @FXML
    private ComboBox<String> cmbxOp1;

    @FXML
    private ComboBox<String> cmbxOp2;

    @FXML
    private ComboBox<String> cmbxOp3;

    @FXML
    private ComboBox<String> cmbxTurno;

    @FXML
    private ComboBox<String> cmbxEstatus;

    @FXML
    private TextField txtEquipR;

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


    @FXML
    public void guardar(MouseEvent event) {
        System.out.println("Guardado");

        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();
        String folio = txtFolio.getText();

        if (!ot.existeOTConFolio(folio)) {
            nuevaOT.setFolio(folio);
            txtFecha.getText();

            String turnoSeleccionado = cmbxTurno.getValue();
            nuevaOT.setTurno(turnoSeleccionado);
            nuevaOT.setEquipoReportado(txtEquipR.getText());
            nuevaOT.setUbicacionEquipo(txtUbiEquipo.getText());
            nuevaOT.setFallaEncontrada(txtFallaE.getText());
            nuevaOT.setFallaReportada(txtFallaR.getText());
            cmbxOp1.getSelectionModel().getSelectedItem();
            cmbxOp2.getSelectionModel().getSelectedItem();
            cmbxOp3.getSelectionModel().getSelectedItem();
            txtHoraInicio.getText();
            txtHoraFin.getText();
            String estatusSeleccionado = cmbxEstatus.getValue();
            nuevaOT.setEstatus(estatusSeleccionado);

            String horaFin = nuevaOT.obtenerHoraFin();
            txtHoraFin.setText(horaFin);

            ot.guardarOT(nuevaOT);
            for (OrdenDeTrabajo orden : ot.getLstOT()) {
                System.out.println(orden);
            }

            ot.agregarFolioGuardado(folio);
        } else {
            System.out.println("La Orden de Trabajo con folio " + folio + " ya ha sido guardada.");
        }
    }
    @FXML
    void nuevaOT(MouseEvent event) {

        System.out.println("nueva OT");
        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();


        folioContador = (folioContador % 999) + 1;
        String nuevoFolio = nuevaOT.generarFolio(folioContador);
        txtFolio.setText(nuevoFolio);

        txtFecha.getText();
        cmbxTurno.setValue(null);
        txtEquipR.setText("");
        txtUbiEquipo.setText("");
        txtFallaE.setText("");
        txtFallaR.setText("");
        cmbxOp1.setValue(null);
        cmbxOp2.setValue(null);
        cmbxOp3.setValue(null);
        txtHoraInicio.getText();
        txtHoraFin.getText();
        cmbxEstatus.setValue(null);

        String estatusSeleccionado = cmbxEstatus.getValue();
        nuevaOT.setEstatus(estatusSeleccionado);

        String horaFin = nuevaOT.obtenerHoraFin();
        txtHoraFin.setText(horaFin);

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrdenDeTrabajo turnosDato = new OrdenDeTrabajo();
        ArrayList<String> turno = turnosDato.getTurno();
        cmbxTurno.getItems().addAll("Mañana", "Tarde", "Noche");

        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();
        txtFolio.setText(nuevaOT.getFolio());
        folioContador = (folioContador % 999) + 1;

        if (nuevaOT == null) {
            nuevaOT = new OrdenDeTrabajo();
        }
        String nuevoFolio = nuevaOT.generarFolio(folioContador);
        txtFolio.setText(nuevoFolio);


        GestorEmpleados empleadoDato = new GestorEmpleados();
        ArrayList<Empleado> lstEmpleado = empleadoDato.getListaEmpleado();

        for (Empleado empleado : lstEmpleado) {
            cmbxOp1.getItems().add(empleado.getNombre());
            cmbxOp2.getItems().add(empleado.getNombre());
            cmbxOp3.getItems().add(empleado.getNombre());
        }


        OrdenDeTrabajo fechas = new OrdenDeTrabajo();
        String fechaActual = fechas.obtenerFechaActual();
        txtFecha.setText(fechaActual);

        OrdenDeTrabajo horasI = new OrdenDeTrabajo();
        String horaInicio = horasI.obtenerHoraInicio();
        txtHoraInicio.setText(horaInicio);

        OrdenDeTrabajo horasF = new OrdenDeTrabajo();
        String horaFin = horasF.obtenerHoraFin();
        txtHoraFin.setText(horaFin);

        OrdenDeTrabajo estatusDatos = new OrdenDeTrabajo();
        ArrayList<String> estatus = estatusDatos.getEstatus();
        cmbxEstatus.getItems().addAll("Pendiente","Pendiente Urgente","Terminado");

    }


}
