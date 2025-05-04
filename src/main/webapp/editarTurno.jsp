<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Turno" %>
<%@ page import="com.gherex.logic.Odontologo" %>
<%@ page import="com.gherex.logic.Paciente" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Modificación de Turnos</h1>
    <p class="mb-3">Este es el apartado para modificar turnos del sistema.</p>

    <div class="container pt-4 w-50" style="min-height: 500px; min-width: 600px;">
        <form class="user" action="/admin/turnos/editar" method="POST">

            <%
            Turno tur = (Turno) request.getSession().getAttribute("turEdit");

            List<Odontologo> listaOdontologosDisponibles = (List<Odontologo>) request.getAttribute("listaOdontologosDisponibles");

            if (listaOdontologosDisponibles == null || listaOdontologosDisponibles.isEmpty()) {
            %>
                <p style="margin-left:10px;"><span style="color: darkred; font-weight: bold;">¡Lo lamentamos!</span> Ningún odontólogo disponible para la fecha seleccionada.</p>
            <%
            } else {
            %>

            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">

                    <label for="odontologo" class="form-label" style="margin-left:10px; font-size: 0.9rem;">Seleccione un odontólogo disponible: </label>
                    <select type="text" class="form-control form-control-user" id="odontologo" name="odontologo" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <%
                        for (Odontologo odo : listaOdontologosDisponibles) {
                        %>
                            <option value="<%= odo.getIdPersona() %>"
                            <%= tur.getUnOdontologo() != null && odo.equals(tur.getUnOdontologo()) ? "selected" : "" %>
                            >
                                <%= odo.getIdPersona() %>: <%= odo.getApellido() %>, <%= odo.getNombre() %>
                            </option>
                        <% } %>
                    </select>

                </div>
                <div class="col-sm-6">

                    <label for="paciente" class="form-label" style="margin-left:10px; font-size: 0.9rem;">Seleccione un paciente: </label>
                    <select type="text" class="form-control form-control-user" id="paciente" name="paciente" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <%
                        List<Paciente> listaPacientes = (List<Paciente>) request.getAttribute("listaPacientes");
                        if (listaPacientes != null) {
                            for (Paciente pac : listaPacientes) {
                        %>
                        <option value="<%= pac.getIdPersona() %>"
                        <%= tur.getUnPaciente() != null && pac.equals(tur.getUnPaciente()) ? "selected" : "" %>
                        >
                            <%= pac.getIdPersona() %>: <%= pac.getApellido() %>, <%= pac.getNombre() %>
                        </option>
                        <% }} %>
                    </select>

                </div>
            </div>

            <div class="col-sm-12 mb-3">
                <input type="text" class="form-control form-control-user" id="afeccion" name="afeccion"
                    placeholder="Afección" value="<%= tur.getAfeccion() %>" required>
            </div>

            <input type="hidden" name="fecha" value="<%= request.getParameter("fecha") %>">
            <input type="hidden" name="hora" value="<%= request.getParameter("hora") %>">

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Guardar Modificación
            </button>

            <% } %>
        </form>
        <form class="user" action="/admin/turnos/editar-fecha" method="GET">
            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Atrás
            </button>
        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>