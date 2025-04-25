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

@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        Usuario usu = logicControl.getUsuario(id);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("usuEdit",usu);

        response.sendRedirect("editarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usu = (Usuario) request.getSession().getAttribute("usuEdit");

        String newUser = request.getParameter("usuario");
        String newPass = request.getParameter("contrasenia");
        String newRol = request.getParameter("rol");

        usu.setNombreUsuario(newUser);
        usu.setContrasenia(newPass);
        usu.setRol(newRol);

        logicControl.modificarUsuario(usu);

        response.sendRedirect("SvUsuarios");

    }
}
