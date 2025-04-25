<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.gherex.logic.Paciente" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Persona ID</th>
                            <th>Responsable</th>
                            <th>Tipo de Sangre</th>
                            <th>Tiene Obra Social</th>
                            <th style="width: 200px;">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Persona ID</th>
                            <th>Responsable</th>
                            <th>Tipo de Sangre</th>
                            <th>Tiene Obra Social</th>
                            <th style="width: 200px;">Acción</th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <%
                    List<Paciente> listaPacientes = (List<Paciente>) request.getSession().getAttribute("listaPacientes");
                    for (Paciente pac : listaPacientes) {
                    %>
                        <tr>
                            <td><%= pac.getIdPersona() %></td>
                            <td><%= pac.getUnResponsable().getIdPersona() %></td>
                            <td><%= pac.getTipoSangre() %></td>
                            <td><%= pac.isTieneObraSocial() %></td>

                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarPaciente" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: #cd4848; margin-right: 5px; width: 110px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getIdPersona() %>"> <!-- esto es para mandar info al servlet -->
                                </form>
                                <form name="editar" action="SvEditarPaciente" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px; width: 110px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getIdPersona() %>"> <!-- esto es para mandar info al servlet -->
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