package org.example.proyectomultidiciplinario.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.proyectomultidiciplinario.GestorOrdenesApplication;
import org.example.proyectomultidiciplinario.models.DataBase;
import org.example.proyectomultidiciplinario.models.Departamento;
import org.example.proyectomultidiciplinario.models.Empleado;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class AgregarDepartamentosController  {

    public TextField txtNombre;
    @FXML
    private Button btnGuardar;
    @FXML
    private ListView<String> ltsvDepartamento;
    @FXML
    private Button btnDelete;

    private ArrayList<Empleado> listaAdmin;
    private ArrayList<Empleado> listaEmpleado;
    private ArrayList<Departamento> lstDepa;
    private Random random = new Random();
    private int cuentasLogeadas;

    // Instancia de la clase de conexión a la base de datos
    DataBase dataBase = new DataBase();

    // Métodos para guardar un nuevo departamento en la base de datos y en la lista
    @FXML
    void btnGuardar(MouseEvent event) {
        int idAleatorio;
        // Generar un ID aleatorio que no esté repetido
        do {
            idAleatorio = random.nextInt(100000);
        } while (idRepetido(idAleatorio));

        // Crear un nuevo objeto Departamento y agregarlo a la lista
        Departamento departamento = new Departamento();
        departamento.setNombreDepartamento(txtNombre.getText());
        departamento.setIdDepartamento(idAleatorio);
        lstDepa.add(departamento);

        // Actualizar la vista de la lista de departamentos
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Departamento departamento1 : lstDepa) {
            items.add(departamento1.toString());
        }
        ltsvDepartamento.setItems(items);

        // Guardar el nuevo departamento en la base de datos
        try (Connection connection = dataBase.getConnection()) {
            String sql = "INSERT INTO department (departement_id, department_name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAleatorio);
            statement.setString(2, txtNombre.getText());
            statement.executeUpdate(); // Ejecuta la consulta para insertar el nuevo departamento
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir errores de SQL
        }
    }

    // Método para modificar el departamento seleccionado
    @FXML
    void btnModificar(MouseEvent event) {
        int selectedIndex = ltsvDepartamento.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            // Obtener el departamento seleccionado y actualizar su nombre
            Departamento depaSeleccionado = lstDepa.get(selectedIndex);
            txtNombre.setText(depaSeleccionado.getNombreDepartamento());

            btnGuardar.setOnAction(e -> {
                depaSeleccionado.setNombreDepartamento(txtNombre.getText());
                ltsvDepartamento.getItems().set(selectedIndex, depaSeleccionado.toString());
                lstDepa.set(selectedIndex, depaSeleccionado);

                // Actualizar el departamento en la base de datos
                try (Connection connection = dataBase.getConnection()) {
                    String sql = "UPDATE department SET department_name = ? WHERE departement_id = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, depaSeleccionado.getNombreDepartamento());
                    statement.setInt(2, depaSeleccionado.getIdDepartamento());
                    statement.executeUpdate(); // Ejecuta la consulta para actualizar el departamento
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Imprimir errores de SQL
                }

                // Mostrar alerta de éxito
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modificado");
                alert.setHeaderText(null);
                alert.setContentText("Departamento modificado con éxito.");
                alert.showAndWait();
                txtNombre.clear();
            });
        } else {
            // Mostrar alerta si no hay ningún elemento seleccionado
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ningún elemento seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un departamento para modificar.");
            alert.showAndWait();
        }
    }

    // Método para eliminar el departamento seleccionado
    @FXML
    void btnDelete(MouseEvent event) {
        int selectedIndex = ltsvDepartamento.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Departamento depaSeleccionado = lstDepa.get(selectedIndex);

            // Eliminar el departamento de la base de datos
            try (Connection connection = dataBase.getConnection()) {
                String sql = "DELETE FROM department WHERE departement_id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, depaSeleccionado.getIdDepartamento());
                statement.executeUpdate(); // Ejecuta la consulta para eliminar el departamento
            } catch (SQLException e) {
                e.printStackTrace(); // Imprimir errores de SQL
            }

            // Actualizar la vista y la lista en memoria
            ltsvDepartamento.getItems().remove(selectedIndex);
            lstDepa.remove(selectedIndex);

            // Mostrar alerta de éxito
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("Eliminado Correctamente");
            alert.showAndWait();
        } else {
            // Mostrar alerta si no hay ningún elemento seleccionado
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ningún elemento seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un elemento para eliminar.");
            alert.showAndWait();
        }
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

    // Método para actualizar la vista de la lista de departamentos
    @FXML
    void ltsvDepartamento(MouseEvent event) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Departamento departamento: lstDepa) {
            items.add(departamento.toString());
        }
        ltsvDepartamento.setItems(items);
    }

    // Método para mostrar la lista de departamentos desde la base de datos
    @FXML
    void btnMostrarLista(MouseEvent event) {
        obtenerDatosDesdeBD(); // Obtener los datos más recientes desde la base de datos
        actualizar(); // Actualizar la vista con los nuevos datos
    }

    // Método para actualizar la vista con la lista actualizada
    public void actualizar() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Departamento departamento : lstDepa) {
            items.add(departamento.toString());
        }
        ltsvDepartamento.setItems(items);
    }

    // Método para obtener la lista de departamentos desde la base de datos
    public void obtenerDatosDesdeBD() {
        // Limpiar la lista antes de cargar nuevos datos
        lstDepa.clear();

        try (Connection connection = dataBase.getConnection()) {
            String sql = "SELECT departement_id, department_name FROM department";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Iterar sobre el resultado y obtiene los datos ya creados
            while (resultSet.next()) {
                int idDepartamento = resultSet.getInt("departement_id");
                String nombreDepartamento = resultSet.getString("department_name");
                Departamento departamento = new Departamento();
                departamento.setIdDepartamento(idDepartamento);
                departamento.setNombreDepartamento(nombreDepartamento);
                lstDepa.add(departamento); // Agregar a la lista para poder mostrarlo
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir errores de SQL
        }
    }

    // Método para verificar si el ID del departamento ya existe
    private boolean idRepetido(int id) {
        for (Departamento departamento : lstDepa) {
            if (departamento.getIdDepartamento() == id) {
                return true;
            }
        }
        return false;
    }

    // Métodos para configurar los datos del controlador
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

    // Inicializar los datos del controlador
    public void initialize() {
        this.listaAdmin = listaAdmin;
        this.listaEmpleado = listaEmpleado;
        this.lstDepa = lstDepa;
    }
}