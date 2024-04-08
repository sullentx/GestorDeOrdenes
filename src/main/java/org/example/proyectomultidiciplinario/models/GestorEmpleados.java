package org.example.proyectomultidiciplinario.models;



import java.util.ArrayList;

public class GestorEmpleados {

    private ArrayList<Empleado> listaEmpleado = new ArrayList<>();
    private ArrayList<Empleado> listaAdmin = new ArrayList<>();


    public int buscarAdministrador(String admin){
        int n=-1;
        for (int i = 0; i<listaAdmin.size(); i++){
            if (listaAdmin.get(i).getNombreUser().equals(admin)){
                n=i;
                break;
            }
        } return n;
    }
    public int buscarEmpleado(String admin){
        int n=-1;
        for (int i = 0; i<listaEmpleado.size(); i++){
            if (listaEmpleado.get(i).getNombreUser().equals(admin)){
                n=i;
                break;
            }
        } return n;
    }
    public boolean addAdmin(Empleado empleado){
        if (buscarAdministrador(empleado.getNombreUser())==-1){
            listaAdmin.add(empleado);
            return true;
        }else{
            return false;
        }
    }

    public boolean addEmpleado(Empleado empleado){
        if (buscarAdministrador(empleado.getNombreUser())==-1){
            listaEmpleado.add(empleado);
            return true;
        }else{
            return false;
        }
    }
    public boolean modificiarAdmin(Empleado admin){
        if(buscarAdministrador(admin.getNombreUser())!=-1){
            Empleado adminAux = obtenerAdmin(admin.getNombreUser());
            adminAux.setNombre(admin.getNombre());
            adminAux.setApellidoPaterno(admin.getApellidoPaterno());
            adminAux.setApellidoMaterno(admin.getApellidoMaterno());
            adminAux.setPassword(admin.getPassword());
            return true;
        }else
            return false;
    }
    public boolean modificiarEmpleado(Empleado empleado){
        if(buscarAdministrador(empleado.getNombreUser())!=-1){
            Empleado empleadoAux = obtenerEmpleado(empleado.getNombreUser());
            empleadoAux.setNombre(empleado.getNombre());
            empleadoAux.setApellidoPaterno(empleado.getApellidoPaterno());
            empleadoAux.setApellidoMaterno(empleado.getApellidoMaterno());
            empleadoAux.setPassword(empleado.getPassword());
            return true;
        }else
            return false;
    }
    public Empleado obtenerAdmin(String admin){
        if (buscarAdministrador(admin)!=-1){
            return listaAdmin.get(buscarAdministrador(admin));
        }else
            return null;
    }
    public Empleado obtenerEmpleado(String admin){
        if (buscarAdministrador(admin)!=-1){
            return listaEmpleado.get(buscarAdministrador(admin));
        }else
            return null;
    }
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

    public boolean eliminarAdmin(String admin){
        if (buscarAdministrador(admin)!=-1){
            listaAdmin.remove(buscarAdministrador(admin));
            return true;
        }else
            return false;
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

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public void setListaAdmin(ArrayList<Empleado> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }
}
