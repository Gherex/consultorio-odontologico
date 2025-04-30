<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.gherex.logic.Usuario" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <h1>Modificación de Usuario</h1>
    <p class="mb-3">Este es el apartado para modificar un usuario del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="/admin/usuarios/editar" method="POST">
            <div class="form-group">

                <%
                Usuario usu = (Usuario) request.getSession().getAttribute("usuEdit");
                %>

                <div class="col-sm-12 mb-3">
                    <input type="text" class="form-control form-control-user" id="usuario" name="usuario"
                        placeholder="Usuario" value="<%= usu.getNombreUsuario() %>">
                </div>

                <div class="col-sm-12 mb-3">
                    <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                        placeholder="Contraseña" value="<%= usu.getContrasenia() %>">
                </div>

                <div class="col-sm-12 mb-3">
                    <input type="text" class="form-control form-control-user" id="rol" name="rol"
                        placeholder="Rol" value="<%= usu.getRol() %>">
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Guardar Modificación
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>