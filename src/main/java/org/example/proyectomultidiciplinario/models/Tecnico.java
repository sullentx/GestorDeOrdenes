package org.example.proyectomultidiciplinario.models;

public class Tecnico extends Empleado {
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

    public boolean verificarUser(String nombreUsuario) {
        return this.nombreUser.equals(nombreUsuario);
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Técnico:");
        stringBuilder.append("  Nombre: ").append(nombre).append("\n");
        stringBuilder.append("  Apellido Paterno: ").append(apellidoPaterno).append("\n");
        stringBuilder.append("  Apellido Materno: ").append(apellidoMaterno).append("\n");
        stringBuilder.append("  Nombre de Usuario: ").append(nombreUser).append("\n");
        stringBuilder.append("  Contraseña: ").append(password).append("\n");
        return stringBuilder.toString();
    }


}
