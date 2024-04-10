package org.example.proyectomultidiciplinario.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.proyectomultidiciplinario.models.OrdenDeTrabajo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OtController implements Initializable {

    @FXML
    private ComboBox<String> cmbxEM;
    @FXML
    private ComboBox<String> cmbxDepartamento;

    @FXML
    private ComboBox<String> cmbxOp;

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
    private ArrayList<Empleado>listaEmpleado;
    private ArrayList<Empleado>listaAdmin;
    private int cuentasLogeadas;
    private ArrayList<Departamento>lstDepa;

    private Empleado empleado;

    public ObservableList<OrdenDeTrabajo> obtenerOrdenesTrabajo() {
        GestorOrdenes gestorOrdenes = GestorOrdenes.getInstancia();
        return FXCollections.observableArrayList(gestorOrdenes.getLstOT());
    }

    private GestorOrdenes ot = GestorOrdenes.getInstancia();


    @FXML
    public void guardar(MouseEvent event) {
        System.out.println("Guardado");

        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();
        String folio = txtFolio.getText();

        if (!ot.existeOTConFolio(folio)) {
            nuevaOT.setFolio(folio);
            txtFecha.getText();

            if (cmbxTurno.getSelectionModel().isEmpty()||txtEquipR.getText().isEmpty()||txtUbiEquipo.getText().isEmpty()||
                    txtFallaE.getText().isEmpty()||
                    txtFallaR.getText().isEmpty()||cmbxEstatus.getSelectionModel().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Favor de rellenar los campos");
                alerta.showAndWait();
            } else {
            String turnoSeleccionado = cmbxTurno.getValue();
            nuevaOT.setTurno(turnoSeleccionado);
            nuevaOT.setEquipoReportado(txtEquipR.getText());
            nuevaOT.setUbicacionEquipo(txtUbiEquipo.getText());
            nuevaOT.setFallaEncontrada(txtFallaE.getText());
            nuevaOT.setFallaReportada(txtFallaR.getText());
            String operadorSeleccionado = cmbxOp.getValue();
            nuevaOT.setOperador(operadorSeleccionado);
            String departamentoSeleccionado = cmbxDepartamento.getValue();
            nuevaOT.setDepartamento(departamentoSeleccionado);
            String encargadoMantenimientoSeleccionado = cmbxEM.getValue();
            nuevaOT.setEM(encargadoMantenimientoSeleccionado);
            txtHoraInicio.getText();
            txtHoraFin.getText();
            String estatusSeleccionado = cmbxEstatus.getValue();
            nuevaOT.setEstatus(estatusSeleccionado);

            String horaFin = nuevaOT.obtenerHoraFin();
            txtHoraFin.setText(horaFin);

            ot.guardarOT(nuevaOT);
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Orden  creada");
                alerta.setHeaderText("Orden de trabajo guardada exitosamente");
                alerta.showAndWait();
            for (OrdenDeTrabajo orden : ot.getLstOT()) {
                System.out.println(orden);
            }

            ot.agregarFolioGuardado(folio);
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Lista Repetida");
            alerta.setHeaderText("Orden de trabajo repetida, favor de crear una nueva Orden de trabajo");
            alerta.setContentText("La Orden de Trabajo con folio " + folio + " ya ha sido guardada.");
            alerta.showAndWait();
            System.out.println("La Orden de Trabajo con folio " + folio + " ya ha sido guardada.");
        }
    }
    @FXML
    void nuevaOT(MouseEvent event) {

        System.out.println("nueva OT");

        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();

        String nuevoFolio;

        if (ot.getLstOT().isEmpty()) {
            nuevoFolio = "001";
        } else {
            String ultimoFolioGuardado = ot.getLstOT().get(ot.getLstOT().size() - 1).getFolio();
            int ultimoNumeroFolio = Integer.parseInt(ultimoFolioGuardado.substring(8));
            nuevoFolio = String.format("%03d", ultimoNumeroFolio + 1);
        }

        String fechaActual = nuevaOT.obtenerFechaActual().replace("/", "");
        nuevoFolio = fechaActual + nuevoFolio;

        txtFolio.setText(nuevoFolio);

        txtFecha.getText();
        cmbxTurno.setValue(null);
        txtEquipR.setText("");
        txtUbiEquipo.setText("");
        txtFallaE.setText("");
        txtFallaR.setText("");
        cmbxOp.setValue(null);
        cmbxDepartamento.setValue(null);
        cmbxEM.setValue(null);
        txtHoraInicio.getText();
        txtHoraFin.getText();
        cmbxEstatus.setValue(null);



        String estatusSeleccionado = cmbxEstatus.getValue();
        nuevaOT.setEstatus(estatusSeleccionado);


        String horaFin = nuevaOT.obtenerHoraFin();
        txtHoraFin.setText(horaFin);

    }


    @FXML
    void btnRegresarMenu(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Crear OT");
            stage.setScene(scene);
            stage.show();
            MenuController menuController = fxmlLoader.getController();
            menuController.setListaAdmin(listaAdmin);
            menuController.setListaEmpleado(listaEmpleado);
            menuController.setCuentasLogeadas(cuentasLogeadas);
            menuController.setLstDepa(lstDepa);
            menuController.initialize();
            if (empleado != null){
                menuController.setEmpleado(empleado);
                menuController.ocultarForEmpleado();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();


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
        generarNuevoFolio();

    }
    private void inicializarComboBoxEmpleados() {
        cmbxOp.getItems().clear();

        if (listaEmpleado != null) {
            for (Empleado empleado : listaEmpleado) {
                cmbxOp.getItems().add(empleado.getNombre());
            }
        } else {
            System.err.println("Error: listaEmpleado es nula");
        }
    }
    private void inicializarComboBoxAdministradores() {
        cmbxEM.getItems().clear();

        if (listaAdmin != null) {
            for (Empleado admin : listaAdmin) {
                cmbxEM.getItems().add(admin.getNombre());
            }
        } else {
            System.err.println("Error: listaAdmin es nula");
        }
    }
    private void inicializarComboBoxDepartamentos() {
        cmbxDepartamento.getItems().clear();

        if (lstDepa != null) {
            for (Departamento departamento : lstDepa) {
                cmbxDepartamento.getItems().add(departamento.getNombreDepartamento());
            }
        } else {
            System.err.println("Error: lstDepa es nula");
        }
    }
    private void generarNuevoFolio() {
        OrdenDeTrabajo nuevaOT = new OrdenDeTrabajo();

        String nuevoFolio;

        if (ot.getLstOT().isEmpty()) {
            nuevoFolio = "001";
        } else {
            String ultimoFolioGuardado = ot.getLstOT().get(ot.getLstOT().size() - 1).getFolio();
            int ultimoNumeroFolio = Integer.parseInt(ultimoFolioGuardado.substring(8));
            nuevoFolio = String.format("%03d", ultimoNumeroFolio + 1);
        }

        String fechaActual = nuevaOT.obtenerFechaActual().replace("/", "");
        nuevoFolio = fechaActual + nuevoFolio;

        txtFolio.setText(nuevoFolio);

    }



    public void setListaAdmin(ArrayList<Empleado> listaAdmin) {
        this.listaAdmin = listaAdmin;
        inicializarComboBoxAdministradores();
    }

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
        inicializarComboBoxEmpleados();
    }

    public void setLstDepa(ArrayList<Departamento> lstDepa) {
        this.lstDepa = lstDepa;
        inicializarComboBoxDepartamentos();
    }
    public void setCuentasLogeadas(int cuentasLogeadas) {
        this.cuentasLogeadas = cuentasLogeadas;
    }
    public void initialize() {
        this.listaAdmin = listaAdmin;
        this.listaEmpleado = listaEmpleado;
        this.cuentasLogeadas = cuentasLogeadas;
        this.lstDepa = lstDepa;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
