package org.example.proyectomultidiciplinario.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;
import org.example.proyectomultidiciplinario.models.GestorOrdenes;

import java.io.IOException;
import java.util.ArrayList;

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
    private GestorOrdenes gestorOrdenes;



    private int cuentasLogeadas;
    private ArrayList<Departamento>lstDepa;


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
            menuIncialController.setLstDepa(lstDepa);
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

            OtController otController = fxmlLoader.getController();
            otController.setListaAdmin(listaAdmin);
            otController.setListaEmpleado(listaEmpleado);
            otController.setCuentasLogeadas(cuentasLogeadas);
            otController.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();

    }

    @FXML
    void btnListaDepartamento(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("agregarDepartamentos.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de usuarios");
            AgregarDepartamentosController agregarDepartamentosController =fxmlLoader.getController();
            agregarDepartamentosController.setListaAdmin(listaAdmin);
            agregarDepartamentosController.setListaEmpleado(listaEmpleado);
            agregarDepartamentosController.setLstDepa(lstDepa);
            agregarDepartamentosController.setCuentasLogeadas(cuentasLogeadas);
            agregarDepartamentosController.initialize();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }


    @FXML
    void btnListaAdministradores(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("listaEmpleados-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("ESAB");
            ListaEmpleadosController listaEmpleadosController =fxmlLoader.getController();
            listaEmpleadosController.setListaAdmin(listaAdmin);
            listaEmpleadosController.setListaEmpleado(listaEmpleado);
            listaEmpleadosController.setCuentasLogeadas(cuentasLogeadas);
            listaEmpleadosController.setLstDepa(lstDepa);
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
    public void btnVerListaOT(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("listOT-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Lista de usuarios");
            listOTController listOTController = fxmlLoader.getController();
            GestorOrdenes gestorOrdenes = GestorOrdenes.getInstancia();

            listOTController.setLstOT(gestorOrdenes);
            listOTController.initialize();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }
    public void btnListaEmpleados(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("listaEmpleadosComunes.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de usuarios");
            ListaEmpleadosComunesController listaEmpleadosComunesController = fxmlLoader.getController();
            listaEmpleadosComunesController.setListaEmpleado(listaEmpleado);
            listaEmpleadosComunesController.setCuentasLogeadas(cuentasLogeadas);
            listaEmpleadosComunesController.setListaAdmin(listaAdmin);
            listaEmpleadosComunesController.setLstDepa(lstDepa);
            listaEmpleadosComunesController.initialize();

            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    public void initialize() {
        this.listaAdmin = listaAdmin;
        this.listaEmpleado = listaEmpleado;
        this.lstDepa = lstDepa;
    }
    public void setLstDepa(ArrayList<Departamento> lstDepa) {
        this.lstDepa = lstDepa;
    }

    public void setCuentasLogeadas(int cuentasLogeadas) {
        this.cuentasLogeadas = cuentasLogeadas;
    }
    public void setListaAdmin(ArrayList<Empleado> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }



    public void setLstOT(GestorOrdenes gestorOrdenes) {

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;

    }
}