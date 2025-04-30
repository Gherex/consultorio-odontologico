package com.gherex.logic;

import jakarta.persistence.*;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "horario_inicio")
    private String horarioInicio;
    @Column(name = "horario_fin")
    private String horarioFin;

    public Horario() {
    }

    public Horario(String horarioInicio, String horarioFin) {
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public Integer getId() {
        return id;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }
}
