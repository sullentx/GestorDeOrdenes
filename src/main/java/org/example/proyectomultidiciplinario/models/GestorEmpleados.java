package org.example.proyectomultidiciplinario.models;

import java.util.ArrayList;

public class GestorEmpleados {

    private ArrayList<Empleado> listaEmpleado=new ArrayList<>();
    private ArrayList<Empleado> listaAdmin=new ArrayList<>();
    public boolean addAdmin(Empleado empleado){
        listaAdmin.add(empleado);
        return true;
    }
    public boolean addEmpleado(Empleado empleado){
        listaEmpleado.add(empleado);
        return true;
    }

    /*public boolean modificarEmpleado(Empleado empleado){
        boolean empleadoEncontrado=false;
        for (int i = 0 ; i <listaEmpleado.size() ; i ++){
            if (listaEmpleado.get(i).getIdIdentificador()==empleado.idIdentificador){
                empleadoEncontrado=true;
                listaEmpleado.get(i).setDepartamento(newEmpleado.getDepartamento());
            }
        }
        return empleadoEncontrado;
    }*/
    public String mostrarAdmins() {
        String nomina = "No se han registrado nuevos empleados";
        if (listaAdmin.isEmpty()) {
            return nomina;
        } else {
            for (int i = 0; i < listaAdmin.size(); i++) {
                nomina = listaAdmin.get(i).toString();
            }
            return nomina;
        }

    }

    public ArrayList<Empleado> getListaAdmin() {
        return listaAdmin;
    }
    public void elimarProducto(int iteradorEmpleado){
        listaEmpleado.remove(iteradorEmpleado);
    }
    public boolean verificacion(String name, String password) {
        for (Empleado empleado : listaAdmin) {
            if (name.equals(empleado.getNombreUser()) && password.equals(empleado.getPassword())) {
                return true;
            }else
                return false;

        }
        return false;
    }

    public boolean verificacionEmpleado(String name, String password) {
        for (Empleado empleado : listaEmpleado) {
            if (name.equals(empleado.getNombreUser()) && password.equals(empleado.getPassword())) {
                return true;
            }
        }
        return false;
    }




}
