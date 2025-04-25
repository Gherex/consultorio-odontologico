package com.gherex.servlets;

import com.gherex.logic.LogicController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvEliminarPaciente", urlPatterns = {"/SvEliminarPaciente"})
public class SvEliminarPaciente extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        logicControl.eliminarPaciente(id);

        response.sendRedirect("SvPacientes");
    }
}