package com.gherex.logic;

import com.gherex.persistence.PersistenceController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogicController {

    private final PersistenceController persisControl;

    public LogicController() {
        this.persisControl = new PersistenceController();
    }

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {
        Usuario usuario = new Usuario(nombreUsuario, contrasenia, rol);
        persisControl.createUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return persisControl.getAllUsuarios();
    }

    public void eliminarUsuario(Integer id) {
        persisControl.deleteUsuario(id);
    }

    public Usuario getUsuario(Integer id) {
        return persisControl.getUsuario(id);
    }

    public void modificarUsuario(Usuario usu) {
        persisControl.updateUsuario(usu);
    }

    public List<Odontologo> getOdontologos() {
        return persisControl.getAllOdontologos();
    }

    public void crearOdontologo(String nombre, String apellido, String dni, String telefono, String direccion, Date fechaNac, String especialidad, Usuario unUsuario, Horario unHorario) {
        Odontologo odo = new Odontologo(dni, nombre, apellido, telefono, direccion, fechaNac, especialidad, unUsuario, unHorario);
        persisControl.createOdontologo(odo);
    }

    public void eliminarOdontologo(Integer id) {
        persisControl.deleteOdontologo(id);
    }

    public Odontologo getOdontologo(Integer id) {
        return persisControl.getOdontologo(id);
    }

    public void modificarOdontologo(Odontologo odo) {
        persisControl.updateOdontologo(odo);
    }

    public List<Paciente> getPacientes() {
        return persisControl.getAllPacientes();
    }

    public void crearPaciente(String nombre, String apellido, String dni, String telefono, String direccion, Date fechaNac, boolean tieneObraSocial, String tipoSangre, Responsable responsable, List<Turno> listaTurnos) {
        Paciente pac = new Paciente(dni, nombre, apellido, telefono, direccion, fechaNac, tieneObraSocial, tipoSangre, responsable, listaTurnos);
        persisControl.createPaciente(pac);
    }

    public void eliminarPaciente(Integer id) {
        persisControl.deletePaciente(id);
    }

    public Paciente getPaciente(Integer id) {
        return persisControl.getPaciente(id);
    }

    public void modificarPaciente(Paciente pac) {
        persisControl.updatePaciente(pac);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = persisControl.getAllUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) return true;
            }
        }

        return false;
    }

    public String obtenerRol(String usuario, String contrasenia) {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = persisControl.getAllUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) return usu.getRol();
            }
        }

        return "guest";
    }

    public List<Secretario> getSecretarios() {
        return persisControl.getAllSecretarios();
    }

    public void crearSecretario(String nombre, String apellido, String dni, String telefono, String direccion, Date fechaNac, String sector, Usuario unUsuario) {
        Secretario sec = new Secretario(dni, nombre, apellido, telefono, direccion, fechaNac, sector, unUsuario);
        persisControl.createSecretario(sec);
    }

    public Secretario getSecretario(Integer id) {
        return persisControl.getSecretario(id);
    }

    public void modificarSecretario(Secretario sec) {
        persisControl.updateSecretario(sec);
    }

    public void eliminarSecretario(Integer id) {
        persisControl.deleteSecretario(id);
    }
}
