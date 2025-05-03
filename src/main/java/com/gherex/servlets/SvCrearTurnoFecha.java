package com.gherex.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SvCrearTurnoFecha", urlPatterns = {"/admin/turnos/seleccionar-fecha"})
public class SvCrearTurnoFecha extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.getRequestDispatcher("/altaTurnosFecha.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        request.setAttribute("fecha", fecha);
        request.setAttribute("hora", hora);

        request.getRequestDispatcher("/admin/turnos/crear").forward(request, response);
    }
}