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

@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/admin/usuarios/editar"})
public class SvEditarUsuario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        Usuario usu = logicControl.getUsuario(id);

        HttpSession session = request.getSession();
        session.setAttribute("usuEdit", usu);
        request.getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Usuario usu = (Usuario) request.getSession().getAttribute("usuEdit");

        String newUser = request.getParameter("usuario");
        String newPass = request.getParameter("contrasenia");
        String newRol = request.getParameter("rol");

        if (usu != null) {
            usu.setNombreUsuario(newUser);
            usu.setContrasenia(newPass);
            usu.setRol(newRol);

            logicControl.modificarUsuario(usu);
        }

        response.sendRedirect(request.getContextPath() + "/usuarios");

    }
}
