package org.example.proyectomultidiciplinario.models;

public class Ingeniero extends Empleado{
    private String tituloIngeniero;

    public Ingeniero(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String password,String rol, String tituloIngeniero) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, password,rol);
        this.tituloIngeniero = tituloIngeniero;
    }


    public Ingeniero() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ingeniero:");
        stringBuilder.append("  Nombre: ").append(nombre).append("\n");
        stringBuilder.append("  Apellido Paterno: ").append(apellidoPaterno).append("\n");
        stringBuilder.append("  Apellido Materno: ").append(apellidoMaterno).append("\n");
        stringBuilder.append("  Nombre de Usuario: ").append(nombreUser).append("\n");
        stringBuilder.append("  Contraseña: ").append(password).append("\n");
        return stringBuilder.toString();
    }



    public void setTituloIngeniero(String tituloIngeniero) {
        this.tituloIngeniero = tituloIngeniero;
    }

}
