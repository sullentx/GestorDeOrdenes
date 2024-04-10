package org.example.proyectomultidiciplinario.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departamento {
    private  String nombreDepartamento;
    private int idDepartamento;

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    @Override
    public String toString() {
        return "ID: " + idDepartamento + " | Nombre: " + nombreDepartamento;
    }
}
