<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Turno" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Alta Turnos</h1>
    <p class="mb-3">Este es el apartado para dar de alta los turnos del sistema.</p>

    <div class="container pt-4 w-50" style="min-height: 500px;">
        <form class="user" action="/admin/turnos/crear" method="GET">
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="fecha" class="form-label" style="margin-left:10px;">Seleccione una fecha de turno: </label>
                    <input type="Date" class="form-control form-control-user" id="fecha" name="fecha"
                        placeholder="Fecha" required>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="hora" class="form-label" style="margin-left:10px;">Seleccione un horario de turno: </label>
                    <select type="text" class="form-control form-control-user" id="hora" name="hora" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <%
                        for (int h = 8; h <= 19; h++) {
                            for (int m = 0; m < 60; m += 30) {
                                String hora = String.format("%02d:%02d", h, m);
                        %>
                                <option value="<%= hora %>"><%= hora %></option>
                        <%
                            }
                        }
                        %>
                    </select>
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Siguiente
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>