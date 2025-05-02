package com.gherex.servlets;

import com.gherex.logic.LogicController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvCrearUsuario", urlPatterns = {"/admin/usuarios/crear"})
public class SvCrearUsuario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/altaUsuarios.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String nombreUsuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");

        logicControl.crearUsuario(nombreUsuario, contrasenia, rol);
        response.sendRedirect(request.getContextPath() + "/usuarios");
    }
}