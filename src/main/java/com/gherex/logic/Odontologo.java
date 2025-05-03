package com.gherex.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

        this.listaTurnos = new ArrayList<Turno>(); //creo un array vacío y luego ya añado los turnos
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

    public void addTurno(Turno tur) {
        this.listaTurnos.add(tur);
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public void deleteTurno(Date fecha, String hora) {
        Iterator<Turno> iter = listaTurnos.iterator();
        while (iter.hasNext()) {
            Turno tur = iter.next();
            if (fecha.equals(tur.getFechaTurno()) && hora.equals(tur.getHoraTurno())) {
                iter.remove();  // elimina el elemento de forma segura
            }
        }
    }

}
