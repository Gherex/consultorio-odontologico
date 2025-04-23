<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Usuario</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body style="margin: 0; padding: 0; user-select: none;">

    <div class="vista-edit-container">
        <%
            User usuarioAEditar = (User) request.getSession().getAttribute("userEditar");
        %>
        <h2>Datos del usuario a editar</h2>
        <form action="SvEditar" method="POST">

            <input type="hidden" name="id" value="<%= usuarioAEditar.getId() %>">

            <label for="dni">DNI:</label>
            <input type="number" id="dni" name="dni" value="<%= usuarioAEditar.getDni() %>"><br><br>

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= usuarioAEditar.getNombre() %>"><br><br>

            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" value="<%= usuarioAEditar.getApellido() %>"><br><br>

            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" value="<%= usuarioAEditar.getTelefono() %>"><br><br>

            <input class="button" type="submit" value="Guardar">
        </form>
        <form action="index.jsp">
            <button class="button" type="submit">Volver</button>
        </form>
    </div>
</body>
</html>
