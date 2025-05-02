<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Usuario" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Alta Secretarios</h1>
    <p class="mb-3">Este es el apartado para dar de alta los diferentes secretarios del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="/admin/secretarios/crear" method="POST">
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                        placeholder="Nombre" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                        placeholder="Apellido" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                        placeholder="DNI" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                        placeholder="Teléfono" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                        placeholder="Dirección" required>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="sector" name="sector"
                        placeholder="Sector" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">
                    <label for="fechaNac" class="form-label" style="margin-left:10px;">Fecha de nacimiento: </label>
                    <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac"
                        placeholder="Fecha de nacimiento" required>
                </div>
                <div class="col-sm-6">
                    <label for="usuario" class="form-label" style="margin-left:10px;">Usuario: </label>
                    <select class="form-control form-control-user" id="usuario" name="usuario" required>
                        <option value="" disabled selected>-- Seleccionar Usuario --</option>
                        <%
                        List<Usuario> usuariosDisponibles = (List<Usuario>) request.getAttribute("usuariosDisponibles");
                        for (Usuario usu : usuariosDisponibles) {
                        %>
                            <option value="<%= usu.getId() %>"><%= usu.getNombreUsuario() %></option>
                        <% } %>
                    </select>
                </div>

            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Crear Secretario
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>