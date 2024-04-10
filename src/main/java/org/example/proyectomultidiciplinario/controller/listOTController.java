package org.example.proyectomultidiciplinario.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.GestorOrdenes;
import org.example.proyectomultidiciplinario.models.OrdenDeTrabajo;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class listOTController implements Initializable {


    @FXML
    private ComboBox<String> cmbxModEstatus;

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
    private GestorOrdenes gestorOrdenes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbxModEstatus.getItems().addAll("Pendiente","Pendiente Urgente","Terminado");
    }

    @FXML
    public void btnActualizar(MouseEvent event) {

        System.out.println("Lista mostrada");
        OtController otController = new OtController();
        ObservableList<OrdenDeTrabajo> ordenesTrabajo = otController.obtenerOrdenesTrabajo();


        colFolio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFolio()));
        colEquipoRepotrtado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEquipoReportado()));
        colUbiEquipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUbicacionEquipo()));
        colFallaEncontrada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFallaEncontrada()));
        colFallaReportada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFallaReportada()));
        colTurno.setCellValueFactory(cellData -> {
            StringProperty value = new SimpleStringProperty();
            if (cellData.getValue() != null && cellData.getValue().getTurno() != null) {
                value.setValue(cellData.getValue().getTurno().get(0));
            }
            return value;
        });

        colEstatus.setCellValueFactory(cellData -> {
            StringProperty value = new SimpleStringProperty();
            if (cellData.getValue() != null && cellData.getValue().getEstatus() != null) {
                value.setValue(cellData.getValue().getEstatus().get(0));
            }
            return value;
        });

        for (OrdenDeTrabajo orden : GestorOrdenes.getInstancia().getLstOT()) {
            System.out.println(orden);
        }
        tblOT.getItems().clear();
        tblOT.setItems(ordenesTrabajo);
    }

    public void setLstOT(GestorOrdenes gestorOrdenes) {
        this.gestorOrdenes = gestorOrdenes;
    }

    public void initialize() {
    }

    public void btnModEstatus(javafx.event.ActionEvent event) {
        OrdenDeTrabajo ordenSeleccionada = tblOT.getSelectionModel().getSelectedItem();
        if (ordenSeleccionada == null) {
            System.out.println("Por favor seleccione una fila.");
            return;
        }
        String nuevoEstatus = cmbxModEstatus.getValue();
        if (nuevoEstatus == null) {
            System.out.println("Por favor seleccione un estatus.");
            return;
        }

        ordenSeleccionada.getEstatus().clear();
        ordenSeleccionada.setEstatus(nuevoEstatus);
        tblOT.refresh();
        System.out.println("Estatus actualizado correctamente.");
    }
    @FXML
    void btnRegresarMenu(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Lista OT");
            stage.setScene(scene);
            stage.show();

            MenuController menuController = fxmlLoader.getController();
            GestorOrdenes gestorOrdenes = GestorOrdenes.getInstancia();

            menuController.setLstOT(gestorOrdenes);
            menuController.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}






