package com.gherex.logic;

public class Horario {

    private Integer id;
    private String horarioInicio;
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
