package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/usuarios"})
public class SvUsuarios extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = logicControl.getUsuarios();

        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("verUsuarios.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST no permitido en esta ruta");
    }
}
