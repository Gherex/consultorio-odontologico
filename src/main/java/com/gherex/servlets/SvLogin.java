package com.gherex.servlets;

import com.gherex.logic.LogicController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSesion = request.getSession();
        miSesion.removeAttribute("usuario");
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        boolean validacion = false;
        validacion = logicControl.comprobarIngreso(usuario, contrasenia);

        if (validacion) {
            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("loginError.jsp");
        }
    }
}