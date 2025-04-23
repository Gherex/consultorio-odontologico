package com.gherex.persistence;

import com.gherex.logic.Usuario;

import java.util.List;

public class PersistenceController {

    UserJpaController userJpa = new UserJpaController();

    public void crearUsuario(Usuario usuario) {
        userJpa.crearUsuario(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return userJpa.obtenerUsuarios();
    }

    public void eliminarUsuario(String idSeleccionado) {
        int id = Integer.parseInt(idSeleccionado);
        userJpa.eliminarUsuario(id);
    }

    public Usuario traerUsuario(int idSeleccionado) {
        return userJpa.buscarUsuarioPorId(idSeleccionado);
    }

    public void actualizarUsuario(Usuario usuarioEdit) {
        userJpa.actualizarUsuario(usuarioEdit);
    }
}