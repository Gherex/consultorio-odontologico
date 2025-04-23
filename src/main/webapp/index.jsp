<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body style="margin: 0; padding: 0; user-select: none;">

    <%
        if (session.getAttribute("listaUsuarios") == null) {
            response.sendRedirect("SvUsuarios");
            return;
        }
    %>

    <h1>Gestión de usuarios</h1>
    <div class="main-container">

        <div class="create-container">
            <h2>Datos del usuario</h2>
            <form action="SvUsuarios" method="POST">
                <label for="dni">DNI:</label>
                <input type="number" id="dni" name="dni"><br><br>

                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre"><br><br>

                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido"><br><br>

                <label for="telefono">Teléfono:</label>
                <input type="number" id="telefono" name="telefono"><br><br>

                <input class="button" type="submit" value="Registrar">
            </form>
        </div>

        <div class="right-side-container">
            <div class="ver-users-container">
                <h2>Ver lista de usuarios</h2>
                <p>Para ver los datos de los usuarios cargados haga click en el siguiente botón:</p>
                <form action="SvUsuarios" method="GET">
                    <input class="button" type="submit" value="Mostrar usuarios">
                </form>
            </div>

            <div class="delete-container">
                <h2>Eliminar Usuario</h2>
                <p>Seleccione el ID del usuario que quiere eliminar</p>
                <form class="row-container" action="SvEliminar" method="POST">
                    <label for="id">ID:</label>
                    <select id="id" name="id">
                    <%
                        List<User> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                            for (User u : listaUsuarios) {
                                String valor = String.valueOf(u.getId());
                    %>
                                <option value=<%= valor %>><%=u.getId()%></option>
                    <%      } %>
                    </select>
                    <br><br>
                    <input class="button" type="submit" value="Eliminar Usuario">
                </form>
            </div>

            <div class="edit-container">
                <h2>Editar Usuario</h2>
                <p>Seleccione el ID del usuario que quiere editar</p>
                <form class="row-container" action="SvEditar" method="GET">
                    <label for="idEditar">ID:</label>
                    <select id="idEditar" name="idEditar">
                    <%
                        List<User> listaUsers = (List) request.getSession().getAttribute("listaUsuarios");
                        for (User u : listaUsers) {
                            String value = String.valueOf(u.getId());
                    %>
                            <option value=<%= value %>><%=u.getId()%></option>
                    <%  } %>
                    </select>
                    <br><br>
                    <input class="button" type="submit" value="Editar Usuario">
                </form>
            </div>
        </div>

    </div>
</body>
</html>