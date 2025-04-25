package com.gherex.logic;

import com.gherex.persistence.PersistenceController;

public class LogicController {

    private final PersistenceController persisControl;

    public LogicController() {
        this.persisControl = new PersistenceController();
    }

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {
        Usuario usuario = new Usuario(nombreUsuario, contrasenia, rol);
        persisControl.createUsuario(usuario);
    }
}
