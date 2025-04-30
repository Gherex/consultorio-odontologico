<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Odontologo" %>
<%@ page import="com.gherex.logic.Usuario" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Modificación de Odontólogos</h1>
    <p class="mb-3">Este es el apartado para modificar odontólogos del sistema.</p>

    <div class="container pt-4 w-50" style="min-height: 500px;">
        <form class="user" action="/admin/odontologos/editar" method="POST">

            <%
            Odontologo odo = (Odontologo) request.getSession().getAttribute("odoEdit");
            %>

            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                        placeholder="Nombre" value="<%= odo.getNombre() %>" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                        placeholder="Apellido" value="<%= odo.getApellido() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                        placeholder="DNI" value="<%= odo.getDni() %>" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                        placeholder="Teléfono" value="<%= odo.getTelefono() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                        placeholder="Dirección" value="<%= odo.getDireccion() %>" required>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad"
                        placeholder="Especialidad" value="<%= odo.getEspecialidad() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">
                    <label for="fechaNac" class="form-label" style="margin-left:10px;">Fecha de nacimiento: </label>
                    <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac"
                        placeholder="Fecha de nacimiento" value="<%= odo.getFechaNacimiento() %>" required>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="usuario" class="form-label" style="margin-left:10px;">Usuario: </label>
                    <select class="form-control form-control-user" id="usuario" name="usuario" required>
                        <option value="" disabled>-- Seleccionar Usuario --</option>
                        <%
                        List<Usuario> usuariosDisponibles = (List<Usuario>) request.getAttribute("usuariosDisponibles");
                        for (Usuario usu : usuariosDisponibles) {
                            boolean seleccionado = odo.getUnUsuario() != null && usu.getId() == odo.getUnUsuario().getId();
                        %>
                            <option value="<%= usu.getId() %>" <%= seleccionado ? "selected" : "" %>>
                                <%= usu.getNombreUsuario() %>
                            </option>
                        <%
                        }
                        %>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">
                    <label for="horaInicio" class="form-label" style="margin-left:10px;">Horario Inicio: </label>
                    <select type="text" class="form-control form-control-user" id="horaInicio" name="horaInicio" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <option value="8" <%= odo.getUnHorario() != null && "8".equals(odo.getUnHorario().getHorarioInicio()) ? "selected" : "" %>>08:00</option>
                        <option value="9" <%= odo.getUnHorario() != null && "9".equals(odo.getUnHorario().getHorarioInicio()) ? "selected" : "" %>>09:00</option>
                        <option value="10" <%= odo.getUnHorario() != null && "10".equals(odo.getUnHorario().getHorarioInicio()) ? "selected" : "" %>>10:00</option>
                        <option value="11" <%= odo.getUnHorario() != null && "11".equals(odo.getUnHorario().getHorarioInicio()) ? "selected" : "" %>>11:00</option>
                        <option value="12" <%= odo.getUnHorario() != null && "12".equals(odo.getUnHorario().getHorarioInicio()) ? "selected" : "" %>>12:00</option>
                    </select>
                </div>
                <div class="col-sm-6">
                    <label for="horaFin" class="form-label" style="margin-left:10px;">Horario Fin: </label>
                    <select type="text" class="form-control form-control-user" id="horaFin" name="horaFin" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <option value="16" <%= odo.getUnHorario() != null && "16".equals(odo.getUnHorario().getHorarioFin()) ? "selected" : "" %>>16:00</option>
                        <option value="17" <%= odo.getUnHorario() != null && "17".equals(odo.getUnHorario().getHorarioFin()) ? "selected" : "" %>>17:00</option>
                        <option value="18" <%= odo.getUnHorario() != null && "18".equals(odo.getUnHorario().getHorarioFin()) ? "selected" : "" %>>18:00</option>
                        <option value="19" <%= odo.getUnHorario() != null && "19".equals(odo.getUnHorario().getHorarioFin()) ? "selected" : "" %>>19:00</option>
                        <option value="20" <%= odo.getUnHorario() != null && "20".equals(odo.getUnHorario().getHorarioFin()) ? "selected" : "" %>>20:00</option>
                    </select>
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Guardar Modificación
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>