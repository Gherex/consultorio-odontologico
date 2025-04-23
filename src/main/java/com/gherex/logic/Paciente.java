package com.gherex.logic;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona {

    private boolean tieneObraSocial;
    private String tipoSangre;
    private Responsable unResponsable;
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, boolean tieneObraSocial, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.tieneObraSocial = tieneObraSocial;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    public boolean isTieneObraSocial() {
        return tieneObraSocial;
    }

    public void setTieneObraSocial(boolean tieneObraSocial) {
        this.tieneObraSocial = tieneObraSocial;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
}
