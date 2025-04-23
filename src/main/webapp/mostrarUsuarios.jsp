<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar Usuarios</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="vista-ver-users-container">
        <h1>Tabla de Usuarios registrados: </h1>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<User> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                        for (User u : listaUsuarios) {
                    %>
                    <tr>
                        <td><%= u.getId() %></td>
                        <td><%= u.getDni() %></td>
                        <td><%= u.getNombre() %></td>
                        <td><%= u.getApellido() %></td>
                        <td><%= u.getTelefono() %></td>
                    </tr>
                    <%  } %>
                </tbody>
            </table>
        </div>
        <form action="index.jsp">
            <button class="button" type="submit">Volver</button>
        </form>
    </div>
</body>
</html>