package com.gherex.logic;

import com.gherex.persistence.PersistenceController;

import java.util.List;

public class LogicController {

    PersistenceController persisControl = new PersistenceController();

    public void crearUsuario(Usuario usuario) {
        persisControl.crearUsuario(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return persisControl.traerUsuarios();
    }

    public void eliminarUsuario(String idSeleccionado) {
        persisControl.eliminarUsuario(idSeleccionado);
    }

    public Usuario traerUsuario(int idSeleccionado) {
        return persisControl.traerUsuario(idSeleccionado);
    }

    public void actualizarUsuario(Usuario usuarioEdit) {
        persisControl.actualizarUsuario(usuarioEdit);
    }
}
