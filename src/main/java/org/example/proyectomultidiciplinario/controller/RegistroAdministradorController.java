package org.example.proyectomultidiciplinario.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;
import org.example.proyectomultidiciplinario.models.Ingeniero;
import org.example.proyectomultidiciplinario.models.Tecnico;

import java.io.IOException;
import java.util.ArrayList;


public class RegistroAdministradorController  {
    private ArrayList<Empleado> listaAdmin;
    private ArrayList<Empleado> listaEmpleado;

    @FXML
    private CheckBox cbIngeniero;

    @FXML
    private Label lbTipoEmpleado;

    @FXML
    private CheckBox cbTecnico;

    @FXML
    private TextField txtApeMaterno;

    @FXML
    private TextField txtApellidoPaterno;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtTipoEmpleado;
    private Stage stage = new Stage();
    private int cuentasLogeadas;
    private ArrayList<Departamento>lstDepa;


    public void btnGuardar(MouseEvent event) {
        if (cbIngeniero.isSelected()){
            cbTecnico.setDisable(true);
            if (txtNombre.getText().isEmpty() || txtApeMaterno.getText().isEmpty() || txtApellidoPaterno.getText().isEmpty() ||
                    txtTipoEmpleado.getText().isEmpty() || txtNombreUsuario.getText().isEmpty() || txtPassword.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacíos");
                alerta.setContentText("Favor de rellenar los campos");
                alerta.showAndWait();
            } else {
                boolean existe = false;
                String nombreUsuario = txtNombreUsuario.getText();
                for (Empleado empleado : listaAdmin) {
                    String nombreUserEmpleado = empleado.getNombreUser();
                    if (nombreUserEmpleado != null && nombreUserEmpleado.equals(nombreUsuario)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText("Nombre de usuario existente");
                    alerta.setContentText("El nombre de usuario ingresado ya está en uso.");
                    alerta.showAndWait();
                } else {
                    Ingeniero ingeniero = new Ingeniero();
                    ingeniero.setNombre(txtNombre.getText());
                    ingeniero.setApellidoPaterno(txtApellidoPaterno.getText());
                    ingeniero.setApellidoMaterno(txtApeMaterno.getText());
                    ingeniero.setTituloIngeniero(txtTipoEmpleado.getText());
                    ingeniero.setNombreUser(txtNombreUsuario.getText());
                    ingeniero.setPassword(txtPassword.getText());
                    txtNombreUsuario.clear();
                    listaAdmin.add(ingeniero);
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("loginAdministrador.fxml"));
                    try {
                        Pane root = fxmlLoader.load();
                        Scene scene = new Scene(root);
                        stage.setTitle("Iniciar sesión");
                        LoginAdministradorController loginAdministradorController = fxmlLoader.getController();
                        loginAdministradorController.setListaAdmin(listaAdmin);
                        loginAdministradorController.setListaEmpleado(listaEmpleado);
                        loginAdministradorController.setCuentasLogeadas(cuentasLogeadas);
                        loginAdministradorController.setLstDepa(lstDepa);
                        loginAdministradorController.initialize();
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
            }
        } else if (cbTecnico.isSelected()){
            cbIngeniero.setDisable(true);
            lbTipoEmpleado.setText("Ingrese Cedula tecnica");
            if (txtNombre.getText().isEmpty()||txtApeMaterno.getText().isEmpty()||txtApellidoPaterno.getText().isEmpty()||
                    txtTipoEmpleado.getText().isEmpty()||
                    txtNombreUsuario.getText().isEmpty()||txtPassword.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Favor de rellenar los campos");
                alerta.showAndWait();
            }else {
                boolean existe = false;
                String nombreUsuario = txtNombreUsuario.getText();
                for (Empleado empleado : listaAdmin) {
                    String nombreUserEmpleado = empleado.getNombreUser();
                    if (nombreUserEmpleado != null && nombreUserEmpleado.equals(nombreUsuario)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText("Nombre de usuario existente");
                    alerta.setContentText("El nombre de usuario ingresado ya está en uso.");
                    alerta.showAndWait();
                }else {
                    Tecnico tecnico = new Tecnico();
                    tecnico.setNombre(txtNombre.getText());
                    tecnico.setApellidoPaterno(txtApellidoPaterno.getText());
                    tecnico.setApellidoMaterno(txtApeMaterno.getText());
                    tecnico.setCedulaTecnica(txtTipoEmpleado.getText());
                    tecnico.setNombreUser(txtNombreUsuario.getText());
                    tecnico.setPassword(txtPassword.getText());
                    txtNombreUsuario.clear();
                    listaAdmin.add(tecnico);
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("loginAdministrador.fxml"));
                    try {
                        Pane root = fxmlLoader.load();
                        Scene scene = new Scene(root);
                        stage.setTitle("Iniciar sesion");
                        LoginAdministradorController loginAdministradorController = fxmlLoader.getController();
                        loginAdministradorController.setListaAdmin(listaAdmin);
                        loginAdministradorController.setListaEmpleado(listaEmpleado);
                        loginAdministradorController.setCuentasLogeadas(cuentasLogeadas);
                        loginAdministradorController.setLstDepa(lstDepa);
                        loginAdministradorController.initialize();
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

        }
        }
    }

    public void btnIrMenu(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menuInicial.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de Empleados");
            MenuIncialController menuIncialController= fxmlLoader.getController();
            menuIncialController.setListaAdmin(listaAdmin);
            menuIncialController.setListaEmpleado(listaEmpleado);
            menuIncialController.setCuentasLogeadas(cuentasLogeadas);
            menuIncialController.setLstDepa(lstDepa);
            menuIncialController.initialize();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();

    }




    @FXML
    void cbIngeniero(MouseEvent event) {
        if (!cbIngeniero.isSelected()){
            txtTipoEmpleado.setDisable(false);
            cbTecnico.setDisable(false);
        }else if (cbIngeniero.isSelected()){
            cbTecnico.setDisable(true);
            lbTipoEmpleado.setText("Ingrese titulo ingenieria");
            txtTipoEmpleado.setDisable(false);
        }else
            cbTecnico.setDisable(false);
        txtTipoEmpleado.setDisable(false);

    }

    @FXML
    void cbTecnico(MouseEvent event) {
        if (!cbTecnico.isSelected()){
            txtTipoEmpleado.setDisable(false);
            cbIngeniero.setDisable(false);
        }else if (cbTecnico.isSelected()){
            cbIngeniero.setDisable(true);
            lbTipoEmpleado.setText("Ingrese cedula tecnica");
            txtTipoEmpleado.setDisable(false);
        }else
            cbIngeniero.setDisable(false);

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



