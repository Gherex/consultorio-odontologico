package com.gherex.logic;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
@Table(name = "odontologos")
public class Odontologo extends Persona {

    private String especialidad;

    @OneToMany(mappedBy = "unOdontologo")
    private List<Turno> listaTurnos;

    @OneToOne
    @JoinColumn(name = "usuario_id") // FK hacia Usuario
    private Usuario unUsuario;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "horario_id") // FK hacia Horario
    private Horario unHorario;

    public Odontologo() {
    }

    public Odontologo(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, String especialidad, Usuario unUsuario, Horario unHorario) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.especialidad = especialidad;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public boolean isTurnoDisponible(Turno turno) {
        return true;
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
