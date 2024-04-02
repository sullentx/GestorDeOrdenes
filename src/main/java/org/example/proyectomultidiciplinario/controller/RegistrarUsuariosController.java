package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;
import org.example.proyectomultidiciplinario.models.Ingeniero;
import org.example.proyectomultidiciplinario.models.Tecnico;


import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


public class RegistrarUsuariosController implements Initializable {

    private GestorEmpleados gestorEmpleados;

    @FXML
    private TextField txtApeMaterno;

    @FXML
    private TextField txtApePaterno;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtPassword;


    @FXML
    private CheckBox cbIngeniero;

    @FXML
    private CheckBox cbTecnico;
    @FXML
    private TextField txtTipoEmpleado;
    @FXML
    private Label lbTipoEmpleado;
    @FXML
    private CheckBox cbIngeniero1;

    @FXML
    private CheckBox cbTecnico1;
    @FXML
    private Label lbTipoEmpleado1;

    @FXML
    private TextField txtTipoEmpleadoEp;
    @FXML
    private TextField txtPasswordEmpleado;
    @FXML
    private TextField txtNombreUsuarioEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtApePaternoEmpleado;
    @FXML
    private TextField txtApeMaternoEmpleado;
    private Tecnico tecnico = new Tecnico();
    private Ingeniero ingeniero = new Ingeniero();



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    void btnGuardarAdmin(MouseEvent event) {
        if (cbIngeniero.isSelected()){
            if (txtNombre.getText().isEmpty()||txtApePaterno.getText().isEmpty()||txtApeMaterno.getText().isEmpty()
                    ||txtNombreUsuario.getText().isEmpty()
                    ||txtPassword.getText().isEmpty()||txtTipoEmpleado.getText().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Campos sin rellenar, favor de rellenarlos");
                alerta.showAndWait();
            }  else {
                ingeniero.setNombre(txtNombre.getText());
                ingeniero.setApellidoPaterno(txtApePaterno.getText());
                ingeniero.setApellidoMaterno(txtApeMaterno.getText());
                ingeniero.setNombreUser(txtNombreUsuario.getText());
                ingeniero.setPassword(txtPassword.getText());
                ingeniero.setTituloIngeniero(txtTipoEmpleado.getText());
                gestorEmpleados = new GestorEmpleados();
                gestorEmpleados.addAdmin(ingeniero);
                System.out.println(ingeniero);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setGestorEmpleados(gestorEmpleados);
                    Stage stage = new Stage();
                    stage.setTitle("Modificar Producto.");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        } else if (cbTecnico.isSelected()){
            if (txtNombre.getText().isEmpty()||txtApePaterno.getText().isEmpty()||txtApeMaterno.getText().isEmpty()
                    ||txtNombreUsuario.getText().isEmpty()
                    ||txtPassword.getText().isEmpty()||txtTipoEmpleado.getText().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Campos sin rellenar, favor de rellenarlos");
                alerta.showAndWait();
            }  else {
                tecnico.setNombre(txtNombre.getText());
                tecnico.setApellidoPaterno(txtApePaterno.getText());
                tecnico.setApellidoMaterno(txtApeMaterno.getText());
                tecnico.setNombreUser(txtNombreUsuario.getText());
                tecnico.setPassword(txtPassword.getText());
                tecnico.setCedulaTecnica(txtTipoEmpleado.getText());
                gestorEmpleados = new GestorEmpleados();
                gestorEmpleados.addAdmin(tecnico);
                System.out.println(tecnico);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setGestorEmpleados(gestorEmpleados);
                    Stage stage = new Stage();
                    stage.setTitle("Modificar Producto.");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        }

    }
    @FXML
    void btnGuardarEmpleado(MouseEvent event) {
        if (cbIngeniero1.isSelected()){
            if (txtNombreEmpleado.getText().isEmpty()||txtApePaternoEmpleado.getText().isEmpty()||txtApeMaternoEmpleado.getText().isEmpty()
                    ||txtNombreUsuarioEmpleado.getText().isEmpty()
                    ||txtPasswordEmpleado.getText().isEmpty()||txtTipoEmpleadoEp.getText().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Campos sin rellenar, favor de rellenarlos");
                alerta.showAndWait();
            }  else {
                ingeniero.setNombre(txtNombreEmpleado.getText());
                ingeniero.setApellidoPaterno(txtApePaternoEmpleado.getText());
                ingeniero.setApellidoMaterno(txtApeMaternoEmpleado.getText());
                ingeniero.setNombreUser(txtNombreUsuarioEmpleado.getText());
                ingeniero.setPassword(txtPasswordEmpleado.getText());
                ingeniero.setTituloIngeniero(txtTipoEmpleadoEp.getText());
                gestorEmpleados = new GestorEmpleados();
                gestorEmpleados.addEmpleado(ingeniero);
                System.out.println(ingeniero);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setGestorEmpleados(gestorEmpleados);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        }else if(cbTecnico1.isSelected()){
            if (txtNombreEmpleado.getText().isEmpty()||txtApePaternoEmpleado.getText().isEmpty()||txtApeMaternoEmpleado.getText().isEmpty()
                    ||txtNombreUsuarioEmpleado.getText().isEmpty()
                    ||txtPasswordEmpleado.getText().isEmpty()||txtTipoEmpleadoEp.getText().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacios");
                alerta.setContentText("Campos sin rellenar, favor de rellenarlos");
                alerta.showAndWait();
            }  else {
                tecnico.setNombre(txtNombreEmpleado.getText());
                tecnico.setApellidoPaterno(txtApePaternoEmpleado.getText());
                tecnico.setApellidoMaterno(txtApeMaternoEmpleado.getText());
                tecnico.setNombreUser(txtNombreUsuarioEmpleado.getText());
                tecnico.setPassword(txtPasswordEmpleado.getText());
                tecnico.setCedulaTecnica(txtTipoEmpleadoEp.getText());
                gestorEmpleados = new GestorEmpleados();
               gestorEmpleados.addEmpleado(tecnico);
                System.out.println(tecnico);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setGestorEmpleados(gestorEmpleados);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        }
    }
    @FXML
    void cbIngeniero(MouseEvent event) {
        if (cbIngeniero.isSelected()){
            cbTecnico.setDisable(true);
        }else
            cbTecnico.setDisable(false);
        if (cbIngeniero.isSelected()){
            txtTipoEmpleado.setDisable(false);
            lbTipoEmpleado.setDisable(false);
            lbTipoEmpleado.setText("Ingrese titulo");
        }
        if (!cbIngeniero.isSelected()){
            txtTipoEmpleado.setDisable(true);
            lbTipoEmpleado.setDisable(true);
            lbTipoEmpleado.setText("");
        }
    }
    @FXML
    void cbTecnico(MouseEvent event) {
        if (cbTecnico.isSelected()){
            cbIngeniero.setDisable(true);
        }else
            cbIngeniero.setDisable(false);
        if (cbTecnico.isSelected()){
            txtTipoEmpleado.setDisable(false);
            lbTipoEmpleado.setDisable(false);
            lbTipoEmpleado.setText("Ingrese cedula");
        }
        else if (!cbTecnico.isSelected()){
            txtTipoEmpleado.setDisable(true);
            lbTipoEmpleado.setDisable(true);
            lbTipoEmpleado.setText("");
        }
    }


    @FXML
    void cbIngeniero1(MouseEvent event) {
        if (cbIngeniero1.isSelected()){
            cbTecnico1.setDisable(true);
        }else
            cbTecnico1.setDisable(false);
        if (cbIngeniero1.isSelected()){
            txtTipoEmpleadoEp.setDisable(false);
            lbTipoEmpleado1.setDisable(false);
            lbTipoEmpleado1.setText("Ingrese titulo");
        }
        if (!cbIngeniero1.isSelected()){
            txtTipoEmpleadoEp.setDisable(true);
            lbTipoEmpleado1.setDisable(true);
            lbTipoEmpleado1.setText("");
        }
    }


    @FXML
    void cbTecnico1(MouseEvent event) {
        if (cbTecnico1.isSelected()){
            cbIngeniero1.setDisable(true);
        }else
            cbIngeniero1.setDisable(false);
        if (cbTecnico1.isSelected()){
            txtTipoEmpleadoEp.setDisable(false);
            lbTipoEmpleado1.setDisable(false);
            lbTipoEmpleado1.setText("Ingrese cedula");
        }
        else if (!cbTecnico1.isSelected()){
            txtTipoEmpleadoEp.setDisable(true);
            lbTipoEmpleado1.setDisable(true);
            lbTipoEmpleado1.setText("");
        }
    }
    public void setGestorEmpleados(GestorEmpleados gestorEmpleados){
        this.gestorEmpleados=gestorEmpleados;
    }
}
