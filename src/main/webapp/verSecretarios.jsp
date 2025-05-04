<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.gherex.logic.Secretario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Secretarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Persona ID</th>
                            <th>Usuario ID</th>
                            <th>Sector</th>
                            <% if ("Admin".equals(rol)) { %> <th style="width: 200px;">Acción</th> <%}%>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Persona ID</th>
                            <th>Usuario ID</th>
                            <th>Sector</th>
                            <% if ("Admin".equals(rol)) { %> <th style="width: 200px;">Acción</th> <%}%>
                        </tr>
                    </tfoot>
                    <tbody>
                    <%
                        List<Secretario> listaSecretarios = (List<Secretario>) request.getAttribute("listaSecretarios");
                        if (listaSecretarios != null) {
                            for (Secretario sec : listaSecretarios) {
                    %>
                                <tr>
                                    <td><%= sec.getIdPersona() %></td>
                                    <td><%= sec.getUnUsuario().getId() %></td>
                                    <td><%= sec.getSector() %></td>

                                    <% if ("Admin".equals(rol)) { %>
                                        <td style="display: flex; width: 230px;">
                                            <form name="eliminar" action="/admin/secretarios/eliminar" method="POST">
                                                <input type="hidden" name="id" value="<%= sec.getIdPersona() %>">
                                                <button type="submit" class="btn btn-danger" style="width: 110px;">
                                                    <i class="fas fa-trash-alt"></i> Eliminar
                                                </button>
                                            </form>
                                            <form name="editar" action="/admin/secretarios/editar" method="GET">
                                                <input type="hidden" name="id" value="<%= sec.getIdPersona() %>">
                                                <button type="submit" class="btn btn-primary" style="width: 110px; margin-left: 10px;">
                                                    <i class="fas fa-pencil-alt"></i> Editar
                                                </button>
                                            </form>
                                        </td>
                                    <% } %>
                                </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="5">No se encontraron secretarios.</td>
                        </tr>
                    <%
                        }
                    %>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>