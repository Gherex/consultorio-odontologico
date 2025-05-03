package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Odontologo;
import com.gherex.logic.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvCrearTurno", urlPatterns = {"/admin/turnos/crear"})
public class SvCrearTurno extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String fechaSelectStr = request.getParameter("fecha");
        Date fechaSeleccionada = null;

        String horaSeleccionada = request.getParameter("hora");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaSeleccionada = sdf.parse(fechaSelectStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Odontologo> odontologosDisponibles = logicControl.getOdontologosDisponibles(fechaSeleccionada, horaSeleccionada);
        List<Paciente> listaPacientes = logicControl.getPacientes();
        request.setAttribute("listaOdontologosDisponibles", odontologosDisponibles);
        request.setAttribute("listaPacientes", listaPacientes);

        request.getRequestDispatcher("/altaTurnos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String fechaStr = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String odontologoIdStr = request.getParameter("odontologo");
        String pacienteIdStr = request.getParameter("paciente");
        String afeccion = request.getParameter("afeccion");

        // Parse fecha
        Date fecha = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int odontologoId = Integer.parseInt(odontologoIdStr);
        int pacienteId = Integer.parseInt(pacienteIdStr);

        Odontologo odontologo = logicControl.getOdontologo(odontologoId);
        Paciente paciente = logicControl.getPaciente(pacienteId);

        logicControl.crearTurno(fecha, hora, odontologo, paciente, afeccion);

        response.sendRedirect("/turnos");
    }

}