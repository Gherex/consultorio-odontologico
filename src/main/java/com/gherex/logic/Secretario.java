package com.gherex.logic;

import java.util.Date;

public class Secretario extends Persona {

    private String sector;
    private Usuario unUsuario;

    public Secretario() {
    }

    public Secretario(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, String sector, Usuario unUsuario) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
}
