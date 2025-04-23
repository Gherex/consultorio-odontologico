package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEditar = Integer.parseInt(request.getParameter("idEditar"));
        Usuario usuario = logicControl.traerUsuario(idEditar);

        // hay que guardar el usuario como una variable de sesión y poder acceder desde cualquier JSP
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("userEditar", usuario);

        response.sendRedirect("editarUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String newDni = request.getParameter("dni");
        String newNombre = request.getParameter("nombre");
        String newApellido = request.getParameter("apellido");
        String newTelefono = request.getParameter("telefono");

        Usuario usuarioEdit = (Usuario) request.getSession().getAttribute("userEditar");

        usuarioEdit.setDni(newDni);
        usuarioEdit.setNombre(newNombre);
        usuarioEdit.setApellido(newApellido);
        usuarioEdit.setTelefono(newTelefono);

        logicControl.actualizarUsuario(usuarioEdit);

        response.sendRedirect("editarUsuarioExitoso.jsp");
    }
}