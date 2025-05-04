<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.gherex.logic.Usuario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <% if ("Admin".equals(rol)) { %> <th style="width: 200px;">Acción</th> <%}%>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <% if ("Admin".equals(rol)) { %> <th style="width: 200px;">Acción</th> <%}%>
                        </tr>
                    </tfoot>
                    <tbody>
                    <%
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
                    for (Usuario usu : listaUsuarios) {
                    %>
                        <tr>
                            <td><%= usu.getId() %></td>
                            <td><%= usu.getNombreUsuario() %></td>
                            <td><%= usu.getRol() %></td>

                            <% if ("Admin".equals(rol)) { %>
                                <td style="display: flex; width: 230px;">
                                    <form name="eliminar" action="/admin/usuarios/eliminar" method="POST">
                                        <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: #cd4848; margin-right: 5px; width: 110px;">
                                            <i class="fas fa-trash-alt"></i> Eliminar
                                        </button>
                                        <input type="hidden" name="id" value="<%= usu.getId() %>"> <!-- esto es para mandar info al servlet -->
                                    </form>
                                    <form name="editar" action="/admin/usuarios/editar" method="GET">
                                        <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px; width: 110px;">
                                            <i class="fas fa-pencil-alt"></i> Editar
                                        </button>
                                        <input type="hidden" name="id" value="<%= usu.getId() %>"> <!-- esto es para mandar info al servlet -->
                                    </form>
                                </td>
                            <% } %>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>