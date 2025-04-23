package com.gherex.logic;

import java.util.Date;

public class Turno {

    private Integer id;
    private Date fechaTurno;
    private String horaTurno;
    private String afeccion;

    public Turno() {
    }

    public Turno(Date fechaTurno, String horaTurno, String afeccion) {
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.afeccion = afeccion;
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
