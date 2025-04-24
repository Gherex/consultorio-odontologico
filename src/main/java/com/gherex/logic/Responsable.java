package com.gherex.logic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
@Table(name = "responsables")
public class Responsable extends Persona {

    @Column(name = "tipo_responsabilidad")
    private String tipoResponsabilidad;

    public Responsable() {
    }

    public Responsable(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, String tipoResponsabilidad) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        this.tipoResponsabilidad = tipoResponsabilidad;
    }

    public String getTipoResponsabilidad() {
        return tipoResponsabilidad;
    }

    public void setTipoResponsabilidad(String tipoResponsabilidad) {
        this.tipoResponsabilidad = tipoResponsabilidad;
    }
}
