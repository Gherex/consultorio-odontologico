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
import java.util.List;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios", "/inicio"})
public class SvUsuarios extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuarios = logicControl.traerUsuarios();

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);

        // Si viene desde /inicio, lo mando al index.jsp
        if (request.getServletPath().equals("/inicio")) {
            response.sendRedirect("index.jsp");
        }
        if (request.getServletPath().equals("/SvUsuarios")) {
            response.sendRedirect("mostrarUsuarios.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        // Usuario newUsuario = new Usuario(dni, nombre, apellido, telefono);
        // logicControl.crearUsuario(newUsuario);

        // actualizo la lista de usuarios para el select
        List<Usuario> listaUsuarios = logicControl.traerUsuarios();

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);

        response.sendRedirect("usuarioGuardado.jsp");
    }
}
