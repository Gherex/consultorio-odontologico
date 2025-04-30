<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Secretario" %>
<%@ page import="com.gherex.logic.Usuario" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Modificación de Secretarios</h1>
    <p class="mb-3">Este es el apartado para modificar secretarios del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="/admin/secretarios/editar" method="POST">
            <div class="form-group row">

                <%
                Secretario sec = (Secretario) request.getSession().getAttribute("secEdit");
                %>

                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                        placeholder="Nombre" value="<%= sec.getNombre() %>" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                        placeholder="Apellido" value="<%= sec.getApellido() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                        placeholder="DNI" value="<%= sec.getDni() %>" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                        placeholder="Teléfono" value="<%= sec.getTelefono() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                        placeholder="Dirección" value="<%= sec.getDireccion() %>" required>
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac"
                        placeholder="Fecha de nacimiento" value="<%= sec.getFechaNacimiento() %>" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="sector" name="sector"
                        placeholder="Sector" value="<%= sec.getSector() %>" required>
                </div>
                <div class="col-sm-6">
                    <select class="form-control form-control-user" id="usuario" name="usuario" required>
                        <option value="" disabled>-- Seleccionar Usuario --</option>
                        <%
                        List<Usuario> usuariosDisponibles = (List<Usuario>) request.getAttribute("usuariosDisponibles");
                        for (Usuario usu : usuariosDisponibles) {
                            boolean seleccionado = sec.getUnUsuario() != null && usu.getId() == sec.getUnUsuario().getId();
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

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Guardar Modificación
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>