package org.example.proyectomultidiciplinario.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.proyectomultidiciplinario.models.OrdenDeTrabajo;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;


public class listOTController implements Initializable {
    @FXML
    private Button btnActualizar;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colEncargadoMant;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colEquipoRepotrtado;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colEstatus;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colFallaEncontrada;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colFallaReportada;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colFolio;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colOperadores;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colTurno;

    @FXML
    private TableColumn<OrdenDeTrabajo, String> colUbiEquipo;

    @FXML
    private TableView<OrdenDeTrabajo> tblOT;


    private ObservableList<OrdenDeTrabajo> listaOT = FXCollections.observableArrayList();
    private OrdenDeTrabajo nuevaOT;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colFolio.setCellValueFactory(new PropertyValueFactory<>("folio"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));

        tblOT.setItems(listaOT);
    }

    @FXML
    public void guardar(MouseEvent event) {
        listaOT.add(nuevaOT);
        actualizarTabla();
    }
    private void actualizarTabla() {
        tblOT.setItems(listaOT);
    }

    public void btnActualizar(MouseEvent event) {
    }
}
