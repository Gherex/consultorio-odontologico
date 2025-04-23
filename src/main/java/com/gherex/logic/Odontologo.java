package com.gherex.logic;

import java.util.Date;
import java.util.List;

public class Odontologo extends Persona {

    private String especialidad;
    private List<Turno> listaTurnos;
    private Usuario unUsuario;
    private Horario unHorario;

    public Odontologo() {
    }

    public Odontologo(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
}
