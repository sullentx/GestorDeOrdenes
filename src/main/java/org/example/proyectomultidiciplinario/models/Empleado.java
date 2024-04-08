package org.example.proyectomultidiciplinario.models;

import java.util.Objects;
import java.util.Random;

public class Empleado {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombreUser;
    protected String password;


    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String password) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreUser = edad;
        this.password=password;
    }

    public Empleado() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNombreUser() {
        return nombreUser;
    }

    public String getPassword() {
        return password;
    }


    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombreUser, empleado.nombreUser) && Objects.equals(password, empleado.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUser, password);
    }


    public String getNombre() {
        return this.nombre;
    }
}