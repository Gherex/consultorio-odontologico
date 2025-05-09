package com.gherex.logic;

import com.gherex.persistence.PersistenceController;
import com.gherex.utils.DateUtils;

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

    public void crearOdontologo(String nombre, String apellido, String dni, String telefono, String direccion, Date fechaNac, String especialidad, Usuario unUsuario, String horarioInicio, String horarioFin) {

        int horaIni = Integer.parseInt(horarioInicio);
        int horaFin = Integer.parseInt(horarioFin);

        if (horaIni >= 8 && horaFin <= 20) {
            Horario horario = new Horario(horarioInicio, horarioFin);
            Odontologo odo = new Odontologo(dni, nombre, apellido, telefono, direccion, fechaNac, especialidad, unUsuario, horario);
            persisControl.createOdontologo(odo); // persiste odontólogo + horario (por cascade)
        } else {
            throw new IllegalArgumentException("El horario debe estar en el rango 08:00 a 20:00");
        }
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

    public void crearPaciente(String nombre, String apellido, String dni, String telefono, String direccion, Date fechaNac, boolean tieneObraSocial, String tipoSangre, Responsable responsable) {
        Paciente pac = new Paciente(dni, nombre, apellido, telefono, direccion, fechaNac, tieneObraSocial, tipoSangre, responsable);
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

    public void crearResponsable(Responsable res) {
        if (DateUtils.calcularEdad(res.getFechaNacimiento()) >= 18) { // tiene que ser mayor de edad
            persisControl.createResponsable(res);
        } else {
            throw new IllegalArgumentException("Un responsable debe ser mayor de edad");
        }
    }

    public List<Odontologo> getOdontologosDisponibles(Date fechaSeleccionada, String horaSeleccionada) {

        List<Odontologo> listaOdontologos = persisControl.getAllOdontologos();
        List<Odontologo> listaOdontologosDisponibles = new ArrayList<>();
        for (Odontologo odo : listaOdontologos) {
            boolean turnoLibre = true;
            if (odo.getListaTurnos() != null) {
                for (Turno tur : odo.getListaTurnos()) {
                    if (fechaSeleccionada.equals(tur.getFechaTurno()) && tur.getHoraTurno().equals(horaSeleccionada)) {
                        turnoLibre = false;
                    }
                }
                if (turnoLibre) listaOdontologosDisponibles.add(odo);
            }
        }
        return listaOdontologosDisponibles;
    }

    public List<Turno> getTurnos() {
        return persisControl.getAllTurnos();
    }

    public void crearTurno(Date fecha, String hora, Odontologo odontologo, Paciente paciente, String afeccion) {
        Turno tur = new Turno(fecha, hora, afeccion, odontologo, paciente);

        odontologo.addTurno(tur);
        paciente.addTurno(tur);
        persisControl.createTurno(tur);
    }

    public void eliminarTurno(Integer id) {
        Turno turnoEliminado = persisControl.getTurno(id);
        Date fecha = turnoEliminado.getFechaTurno();
        String hora = turnoEliminado.getHoraTurno();
        turnoEliminado.getUnOdontologo().deleteTurno(fecha, hora);
        turnoEliminado.getUnPaciente().deleteTurno(fecha, hora);
        persisControl.deleteTurno(id);
    }

    public Turno getTurno(Integer id) {
        return persisControl.getTurno(id);
    }

    public void modificarTurno(Turno turnoModificado) {
        Turno turnoOriginal = persisControl.getTurno(turnoModificado.getId());

        // Eliminar el turno anterior de las listas
        turnoOriginal.getUnOdontologo().deleteTurno(turnoOriginal.getFechaTurno(), turnoOriginal.getHoraTurno());
        turnoOriginal.getUnPaciente().deleteTurno(turnoOriginal.getFechaTurno(), turnoOriginal.getHoraTurno());

        // Agregar el nuevo turno a las nuevas listas
        turnoModificado.getUnOdontologo().addTurno(turnoModificado);
        turnoModificado.getUnPaciente().addTurno(turnoModificado);

        persisControl.updateTurno(turnoModificado);
    }

}
