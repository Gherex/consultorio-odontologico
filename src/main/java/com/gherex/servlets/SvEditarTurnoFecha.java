package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Turno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SvEditarTurnoFecha", urlPatterns = {"/admin/turnos/editar-fecha"})
public class SvEditarTurnoFecha extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));

        Turno tur = logicControl.getTurno(id);

        HttpSession session = request.getSession();
        session.setAttribute("turEdit", tur);

        request.getRequestDispatcher("/editarTurnoFecha.jsp").forward(request, response);
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

        request.getRequestDispatcher("/admin/turnos/editar").forward(request, response);
    }
}