package com.gherex.logic;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
@Table(name = "secretarios")
public class Secretario extends Persona {

    private String sector;
    @OneToOne
    @JoinColumn(name = "un_usuario")
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
