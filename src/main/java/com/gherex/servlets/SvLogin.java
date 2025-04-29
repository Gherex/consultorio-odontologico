package com.gherex.servlets;

import com.gherex.logic.LogicController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "SvLogin", urlPatterns = {"/login"})
public class SvLogin extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSesion = request.getSession();
        if (miSesion.getAttribute("usuario") != null) miSesion.removeAttribute("usuario");
        if (miSesion.getAttribute("rol") != null) miSesion.removeAttribute("rol");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        boolean validacion = false;
        validacion = logicControl.comprobarIngreso(usuario, contrasenia);

        if (validacion) {
            String rol;
            rol = logicControl.obtenerRol(usuario, contrasenia);
            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("usuario", usuario);
            miSesion.setAttribute("rol", rol);
            response.sendRedirect(request.getContextPath() + "/inicio");
        } else {
            response.sendRedirect(request.getContextPath() + "/login-error");
        }
    }
}