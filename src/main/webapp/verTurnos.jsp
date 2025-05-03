<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.gherex.logic.Turno" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Afección</th>
                            <th>ID Odontólogo</th>
                            <th>ID Paciente</th>
                            <th style="width: 200px;">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Afección</th>
                            <th>ID Odontólogo</th>
                            <th>ID Paciente</th>
                            <th style="width: 200px;">Acción</th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <%
                    List<Turno> listaTurnos = (List<Turno>) request.getAttribute("listaTurnos");
                    for (Turno tur : listaTurnos) {
                    %>
                        <tr>
                            <td><%= tur.getId() %></td>
                            <td><%= tur.getFechaTurno() %></td>
                            <td><%= tur.getHoraTurno() %></td>
                            <td><%= tur.getAfeccion() %></td>
                            <td><%= tur.getUnOdontologo().getIdPersona() %></td>
                            <td><%= tur.getUnPaciente().getIdPersona() %></td>

                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="/admin/turnos/eliminar" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: #cd4848; margin-right: 5px; width: 110px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= tur.getId() %>"> <!-- esto es para mandar info al servlet -->
                                </form>
                                <form name="editar" action="/admin/turnos/editar-fecha" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px; width: 110px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= tur.getId() %>"> <!-- esto es para mandar info al servlet -->
                                </form>
                            </td>

                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>