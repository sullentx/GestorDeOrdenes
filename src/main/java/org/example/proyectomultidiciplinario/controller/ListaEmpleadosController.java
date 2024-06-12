package org.example.proyectomultidiciplinario.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ListaEmpleadosController  {
    public Button btnVolver ;
    public Button btnMostrarLista;
    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtApeMaterno;

    @FXML
    private TextField txtApePaterno;

    @FXML
    private TextField txtNameUser;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPassword;
    private Empleado empleado;
    private ArrayList<Empleado>listaAdmin;
    private ArrayList<Empleado>listaEmpleado;
    @FXML
    private ListView<String> ltsAdministradores;

    private int cuentasLogeadas;

    private ArrayList<Departamento>lstDepa;



        @FXML
        void btnLimpiar(MouseEvent event) {
        txtNombre.clear();
        txtApePaterno.clear();
        txtApeMaterno.clear();
        txtNameUser.clear();
        txtPassword.clear();
        }

    @FXML
    void btnModificar(MouseEvent event) {
        int selectedIndex = ltsAdministradores.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Empleado empleadoSeleccionado = listaAdmin.get(selectedIndex);

            txtNombre.setText(empleadoSeleccionado.getNombre());
            txtApePaterno.setText(empleadoSeleccionado.getApellidoPaterno());
            txtApeMaterno.setText(empleadoSeleccionado.getApellidoMaterno());
            txtNameUser.setText(empleadoSeleccionado.getNombreUser());
            txtPassword.setText(empleadoSeleccionado.getPassword());
                btnGuardar.setOnAction(e -> {
                    if (txtNombre.getText().isEmpty()||txtApePaterno.getText().isEmpty()||txtApeMaterno.getText().isEmpty()||
                            txtNameUser.getText().isEmpty()||txtPassword.getText().isEmpty()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Campos Vacios");
                        alert.setHeaderText(null);
                        alert.setContentText("Rellenar espacios vacios.");
                        alert.showAndWait();
                        actualizarLista();
                    }else{
                    boolean existe = false;
                    String nombreUsuario = txtNameUser.getText();
                    for (Empleado empleado : listaAdmin) {
                        String nombreUserEmpleado = empleado.getNombreUser();
                        if (nombreUserEmpleado != null && nombreUserEmpleado.equals(nombreUsuario)) {
                            existe = true;
                        }
                    }
                    if (existe) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Error");
                        alerta.setHeaderText("Nombre de usuario existente");
                        alerta.setContentText("El nombre de usuario ingresado ya está en uso.");
                        alerta.showAndWait();
                    }else{
                empleadoSeleccionado.setNombre(txtNombre.getText());
                empleadoSeleccionado.setApellidoPaterno(txtApePaterno.getText());
                empleadoSeleccionado.setApellidoMaterno(txtApeMaterno.getText());
                empleadoSeleccionado.setNombreUser(txtNameUser.getText());
                empleadoSeleccionado.setPassword(txtPassword.getText());
                ltsAdministradores.getItems().set(selectedIndex, empleadoSeleccionado.toString());
                listaAdmin.set(selectedIndex, empleadoSeleccionado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modificado");
                alert.setHeaderText(null);
                alert.setContentText("Empleado modificado con éxito.");
                alert.showAndWait();
                actualizarLista();
            }
                }
                });


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ningún elemento seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un empleado para modificar.");
            alert.showAndWait();
        }
    }

        @FXML
        void btnMostrarLista(MouseEvent event){
          actualizarLista();
       }

    @FXML
    void btnEliminar(MouseEvent event) {
        int selectedIndex = ltsAdministradores.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ltsAdministradores.getItems().remove(selectedIndex);
            listaAdmin.remove(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("Adminsitrador borrado con exito");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ningún elemento seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un elemento para eliminar.");
            alert.showAndWait();
        }
    }



    public void ltsAdministradores(MouseEvent event) {
        actualizarLista();
    }

    @FXML
    void btnVolver(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
        Stage stage = new Stage();
        try {
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Registro de Empleados");
            MenuController menuController = fxmlLoader.getController();
            menuController.setListaEmpleado(listaEmpleado);
            menuController.setListaAdmin(listaAdmin);
            menuController.setCuentasLogeadas(cuentasLogeadas);
            menuController.setLstDepa(lstDepa);
            menuController.initialize();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnGuardar(MouseEvent event) {

    }
    public void actualizarLista(){
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Empleado empleado : listaAdmin) {
            items.add(empleado.toString());
        }
        ltsAdministradores.setItems(items);
    }

    public void btnAgregar(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("agregarAdministradores.fxml"));
        Stage stage = new Stage();
        try {
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Registro de Empleados");
            AgregarAdministradoresController agregarAdministradoresController = fxmlLoader.getController();
            agregarAdministradoresController.setListaEmpleado(listaEmpleado);
            agregarAdministradoresController.setListaAdmin(listaAdmin);
            agregarAdministradoresController.setCuentasLogeadas(cuentasLogeadas);
            agregarAdministradoresController.setLstDepa(lstDepa);
            agregarAdministradoresController.initialize();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
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

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
}



