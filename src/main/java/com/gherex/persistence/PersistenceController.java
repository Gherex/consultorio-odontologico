package com.gherex.persistence;

import com.gherex.logic.Odontologo;
import com.gherex.logic.Persona;
import com.gherex.logic.Paciente;
import com.gherex.logic.Responsable;
import com.gherex.logic.Secretario;
import com.gherex.logic.Usuario;
import com.gherex.logic.Turno;
import com.gherex.logic.Horario;

import java.util.List;

public class PersistenceController {

    private final PersonaJpaController personaJpa = new PersonaJpaController();
    private final OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    private final PacienteJpaController pacienteJpa = new PacienteJpaController();
    private final ResponsableJpaController responsableJpa = new ResponsableJpaController();
    private final SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    private final UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    private final TurnoJpaController turnoJpa = new TurnoJpaController();
    private final HorarioJpaController horarioJpa = new HorarioJpaController();

    public void createPersona(Persona per) {
        personaJpa.create(per);
    }

    public void updatePersona(Persona per) {
        personaJpa.edit(per);
    }

    public void deletePersona(int id) {
        personaJpa.destroy(id);
    }

    public Persona getPersona(int id) {
        return personaJpa.findPersona(id);
    }

    public List<Persona> getAllPersonas() {
        return personaJpa.findPersonaEntities();
    }

    /* -------------- */

    public void createOdontologo(Odontologo odo) {
        odontologoJpa.create(odo);
    }

    public void updateOdontologo(Odontologo odo) {
        odontologoJpa.edit(odo);
    }

    public void deleteOdontologo(int id) {
        odontologoJpa.destroy(id);
    }

    public Odontologo getOdontologo(int id) {
        return odontologoJpa.findOdontologo(id);
    }

    public List<Odontologo> getAllOdontologos() {
        return odontologoJpa.findOdontologoEntities();
    }

    /* -------------- */

    public void createPaciente(Paciente pac) {
        pacienteJpa.create(pac);
    }

    public void updatePaciente(Paciente pac) {
        pacienteJpa.edit(pac);
    }

    public void deletePaciente(int id) {
        pacienteJpa.destroy(id);
    }

    public Paciente getPaciente(int id) {
        return pacienteJpa.findPaciente(id);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteJpa.findPacienteEntities();
    }

    /* -------------- */

    public void createResponsable(Responsable res) {
        responsableJpa.create(res);
    }

    public void updateResponsable(Responsable res) {
        responsableJpa.edit(res);
    }

    public void deleteResponsable(int id) {
        responsableJpa.destroy(id);
    }

    public Responsable getResponsable(int id) {
        return responsableJpa.findResponsable(id);
    }

    public List<Responsable> getAllResponsables() {
        return responsableJpa.findResponsableEntities();
    }

    /* -------------- */

    public void createSecretario(Secretario sec) {
        secretarioJpa.create(sec);
    }

    public void updateSecretario(Secretario sec) {
        secretarioJpa.edit(sec);
    }

    public void deleteSecretario(int id) {
        secretarioJpa.destroy(id);
    }

    public Secretario getSecretario(int id) {
        return secretarioJpa.findSecretario(id);
    }

    public List<Secretario> getAllSecretarios() {
        return secretarioJpa.findSecretarioEntities();
    }

    /* -------------- */

    public void createUsuario(Usuario usu) {
        usuarioJpa.create(usu);
    }

    public void updateUsuario(Usuario usu) {
        usuarioJpa.edit(usu);
    }

    public void deleteUsuario(int id) {
        usuarioJpa.destroy(id);
    }

    public Usuario getUsuario(int id) {
        return usuarioJpa.findUsuario(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    /* -------------- */

    public void createTurno(Turno tur) {
        turnoJpa.create(tur);
    }

    public void updateTurno(Turno tur) {
        turnoJpa.edit(tur);
    }

    public void deleteTurno(int id) {
        turnoJpa.destroy(id);
    }

    public Turno getTurno(int id) {
        return turnoJpa.findTurno(id);
    }

    public List<Turno> getAllTurnos() {
        return turnoJpa.findTurnoEntities();
    }

    /* -------------- */

    public void createHorario(Horario hor) {
        horarioJpa.create(hor);
    }

    public void updateHorario(Horario hor) {
        horarioJpa.edit(hor);
    }

    public void deleteHorario(int id) {
        horarioJpa.destroy(id);
    }

    public Horario getHorario(int id) {
        return horarioJpa.findHorario(id);
    }

    public List<Horario> getAllHorarios() {
        return horarioJpa.findHorarioEntities();
    }


}
