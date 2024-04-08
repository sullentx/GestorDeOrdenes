package org.example.proyectomultidiciplinario.models;

import java.util.ArrayList;

public class GestorOrdenes {
    private ArrayList<OrdenDeTrabajo> lstOT = new ArrayList<>();
    private ArrayList<String> foliosGuardados;

    public ArrayList<OrdenDeTrabajo> getLstOT() {
        return lstOT;
    }
    public void guardarOT(OrdenDeTrabajo ordenDeTrabajo){lstOT.add(ordenDeTrabajo);}

    public GestorOrdenes() {
        lstOT = new ArrayList<>();
        foliosGuardados = new ArrayList<>();
    }

    public boolean existeOTConFolio(String folio) {
        return foliosGuardados.contains(folio);
    }

    public void agregarFolioGuardado(String folio) {
        foliosGuardados.add(folio);
    }
}


