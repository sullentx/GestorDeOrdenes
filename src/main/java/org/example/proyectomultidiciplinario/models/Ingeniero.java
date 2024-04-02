package org.example.proyectomultidiciplinario.models;

public class Ingeniero extends Empleado{
    private String tituloIngeniero;

    public Ingeniero(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String password, String tituloIngeniero) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, password);
        this.tituloIngeniero = tituloIngeniero;
    }


    public Ingeniero() {

    }

    @Override
    public String toString() {
        return "Ingeniero{" +
                "tituloIngeniero='" + tituloIngeniero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombreUser='" + nombreUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setTituloIngeniero(String tituloIngeniero) {
        this.tituloIngeniero = tituloIngeniero;
    }
}
