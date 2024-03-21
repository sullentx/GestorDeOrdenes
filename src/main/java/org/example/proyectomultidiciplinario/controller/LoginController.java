package org.example.proyectomultidiciplinario.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController  implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField txtNombreUser;

    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnAgregarUsers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void btnIniciarSesion(MouseEvent event) {

    }

    @FXML
    void btnAgregarUsers(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarUsuarios-viem.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void initialize() {

    }



}