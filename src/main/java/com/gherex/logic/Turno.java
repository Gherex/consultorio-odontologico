package com.gherex.logic;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date fechaTurno;
    @Basic
    private String horaTurno;
    private String afeccion;
    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo unOdontologo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente unPaciente;

    public Turno() {
    }

    public Turno(Date fechaTurno, String horaTurno, String afeccion, Odontologo unOdontologo, Paciente unPaciente) {
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.afeccion = afeccion;
        this.unOdontologo = unOdontologo;
        this.unPaciente = unPaciente;
    }

    public Paciente getUnPaciente() {
        return unPaciente;
    }

    public void setUnPaciente(Paciente unPaciente) {
        this.unPaciente = unPaciente;
    }

    public Odontologo getUnOdontologo() {
        return unOdontologo;
    }

    public void setUnOdontologo(Odontologo unOdontologo) {
        this.unOdontologo = unOdontologo;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

}
