package org.example.proyectomultidiciplinario.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrdenDeTrabajo {
    private String equipoReportado;
    private String ubicacionEquipo;
    private String fallaEncontrada;
    private String fallaReportada;
    private int folioContador = 0;
    private String folio;
    private String operador;
    private String departamento;
    private String encargadoMantenimiento;




    private ArrayList <String> turno = new ArrayList<>();
    private ArrayList <String> estatus = new ArrayList<>();


    public ArrayList<String> getTurno() {
        return turno;
    }

    public ArrayList<String> getEstatus() {
        return estatus;
    }

    public OrdenDeTrabajo() {

    }

    public void setEquipoReportado(String equipoReportado) {
        this.equipoReportado = equipoReportado;
    }

    public void setUbicacionEquipo(String ubicacionEquipo) {
        this.ubicacionEquipo = ubicacionEquipo;
    }

    public void setFallaEncontrada(String fallaEncontrada) {
        this.fallaEncontrada = fallaEncontrada;
    }

    public void setFallaReportada(String fallaReportada) {
        this.fallaReportada = fallaReportada;
    }
    public void setTurno(String turnoSeleccionado) {
        this.turno.add(turnoSeleccionado);
    }


    public void setEstatus(String estatus) {
        this.estatus.add(estatus);
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getEquipoReportado() {
        return equipoReportado;
    }

    public String getUbicacionEquipo() {
        return ubicacionEquipo;
    }

    public String getFallaEncontrada() {
        return fallaEncontrada;
    }

    public String getFallaReportada() {
        return fallaReportada;
    }
    public String getFolio() {
        return folio;
    }

    public String getOperador() {
        return operador;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getEncargadoMantenimiento() {
        return encargadoMantenimiento;
    }

    public OrdenDeTrabajo(String equipoReportado, String ubicacionEquipo, String fallaEncontrada, String fallaReportada) {
        this.equipoReportado = equipoReportado;
        this.ubicacionEquipo = ubicacionEquipo;
        this.fallaEncontrada = fallaEncontrada;
        this.fallaReportada = fallaReportada;
}

    public String generarFolio(int contador) {
        String fechaActual = obtenerFechaActual().replace("/", "");
        String contadorFolio = String.format("%03d", contador);
        return fechaActual + contadorFolio; // Generar y retornar el nuevo folio
    }

    public String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fechaFormateada = fechaActual.format(formato);

        return fechaFormateada;
    }

    public String obtenerHoraInicio() {
        LocalTime horaInicio = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        String horaInicial = horaInicio.format(formato);

        return horaInicial;
    }

    public String obtenerHoraFin() {
        LocalTime horaFin = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return horaFin.format(formato);
    }

    @Override
    public String toString() {
        return "folio='" + folio + "', equipoReportado='" + equipoReportado + "', ubicacionEquipo='" + ubicacionEquipo +
                "', fallaEncontrada='" + fallaEncontrada + "', fallaReportada='" + fallaReportada +
                "', operador='" + operador + "', departamento='" + departamento + "', encargadoMantenimiento='" + encargadoMantenimiento +
                "', turno=" + turno + ", estatus=" + estatus;
    }


    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setEM(String encargadoMantenimiento) {
        this.encargadoMantenimiento = encargadoMantenimiento;
    }
}
