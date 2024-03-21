package org.example.proyectomultidiciplinario.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarUsuariosController {
    @FXML private Button btnGuardarUsuarios;

    public void closeWindows() {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/org.example.proyectomultidiciplinario/login-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnGuardarUsuarios.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnGuardarUsuarios(MouseEvent mouseEvent) {

    }
}
