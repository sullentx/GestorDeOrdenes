package org.example.proyectomultidiciplinario.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.GestorEmpleados;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController  implements Initializable {


    @FXML
    private TextField txtNombreUser;

    @FXML
    private TextField txtPassword;
    private GestorEmpleados gestorEmpleados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void btnAgregarUsers(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("RegistrarUsuarios-viem.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("Registro de usuarios");
            RegistrarUsuariosController registrarUsuariosController = fxmlLoader.getController();
            registrarUsuariosController.setGestorEmpleados(gestorEmpleados);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    @FXML
    void btnIniciarSesion(MouseEvent event) {
        try{
        if (txtNombreUser.getText().isEmpty()||txtPassword.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Inicio de sesión fallido");
            alerta.setContentText("Rellene los campos por favor");
            alerta.showAndWait();
        }else {
        if (gestorEmpleados.verificacion(txtNombreUser.getText(),txtPassword.getText())){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
            try {
                Pane root = fxmlLoader.load();
                MenuController menuController = fxmlLoader.getController();
                menuController.setGestorEmpleados(gestorEmpleados);
                Scene scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (gestorEmpleados.verificacionEmpleado(txtNombreUser.getText(),txtPassword.getText())){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(GestorOrdenesApplication.class.getResource("menu-view.fxml"));
            try {
                Pane root = fxmlLoader.load();
                MenuController menuController = fxmlLoader.getController();
                menuController.ocultarForEmpleado();
                menuController.setGestorEmpleados(gestorEmpleados);
                Scene scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Inicio de sesión fallido");
            alerta.setContentText("Contraseña o usario incorrecto");
            alerta.showAndWait();
        }
        }
        }catch(NullPointerException e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Inicio de sesión fallido");
            alerta.setContentText("Agrege usuarios para poder inicar sesion");
            alerta.showAndWait();
        }
        }

        public void setGestorEmpleados(GestorEmpleados gestorEmpleados){
        this.gestorEmpleados=gestorEmpleados;
        }

}
