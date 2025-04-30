package com.gherex.servlets;

import com.gherex.logic.LogicController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvEliminarSecretario", urlPatterns = {"/admin/secretarios/eliminar"})
public class SvEliminarSecretario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        logicControl.eliminarSecretario(id);

        response.sendRedirect(request.getContextPath() + "/secretarios");

    }
}