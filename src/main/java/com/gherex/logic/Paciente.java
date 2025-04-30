package com.gherex.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
@Table(name = "pacientes")
public class Paciente extends Persona {

    @Column(name = "tiene_obra_social")
    private boolean tieneObraSocial;
    @Column(name = "tipo_sangre")
    private String tipoSangre;
    @OneToOne
    @JoinColumn(name = "un_responsable")
    private Responsable unResponsable;
    @OneToMany (mappedBy = "unPaciente")
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, boolean tieneObraSocial, String tipoSangre, Responsable unResponsable) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.tieneObraSocial = tieneObraSocial;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;

        this.listaTurnos = new ArrayList<Turno>(); //creo un array vacío y luego ya añado los turnos
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

    public void addTurno(Turno turno) {
        listaTurnos.add(turno);
    }
}
