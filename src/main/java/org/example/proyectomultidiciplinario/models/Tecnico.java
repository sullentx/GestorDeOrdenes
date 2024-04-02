package org.example.proyectomultidiciplinario.models;

public class Tecnico extends Empleado{
    private String cedulaTecnica;

    public Tecnico(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String password, String cedulaTecnica) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, password);
        this.cedulaTecnica = cedulaTecnica;
    }

    public Tecnico() {

    }


    public void setCedulaTecnica(String cedulaTecnica) {
        this.cedulaTecnica = cedulaTecnica;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "cedulaTecnica='" + cedulaTecnica + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombreUser='" + nombreUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
