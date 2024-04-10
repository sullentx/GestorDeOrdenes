package org.example.proyectomultidiciplinario.models;

import java.util.ArrayList;

public class GestorOrdenes {
    private static GestorOrdenes instancia = null;
    private ArrayList<OrdenDeTrabajo> lstOT = new ArrayList<>();
    private ArrayList<String> foliosGuardados;

    GestorOrdenes() {

        foliosGuardados = new ArrayList<>();
    }

    public static GestorOrdenes getInstancia() {
        if (instancia == null) {
            instancia = new GestorOrdenes();
        }
        return instancia;
    }

    public ArrayList<OrdenDeTrabajo> getLstOT() {
        return lstOT;
    }

    public void setLstOT(ArrayList<OrdenDeTrabajo> lstOT) {
        this.lstOT = lstOT;
    }

    public void guardarOT(OrdenDeTrabajo ordenDeTrabajo) {
        lstOT.add(ordenDeTrabajo);
    }

    public boolean existeOTConFolio(String folio) {
        return foliosGuardados.contains(folio);
    }

    public void agregarFolioGuardado(String folio) {
        foliosGuardados.add(folio);
    }
}

