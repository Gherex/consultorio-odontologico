package com.gherex.servlets;

import com.gherex.logic.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvEditarTurno", urlPatterns = {"/admin/turnos/editar"})
public class SvEditarTurno extends HttpServlet {

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

        request.getRequestDispatcher("/editarTurno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Turno tur = (Turno) request.getSession().getAttribute("turEdit");

        String newHora = request.getParameter("hora");
        String newAfeccion = request.getParameter("afeccion");

        String newIdOdontologoStr = request.getParameter("odontologo");
        int newIdOdontologo = Integer.parseInt(newIdOdontologoStr);
        Odontologo newOdontologo = logicControl.getOdontologo(newIdOdontologo);

        String newIdPacienteStr = request.getParameter("paciente");
        int newIdPaciente = Integer.parseInt(newIdPacienteStr);
        Paciente newPaciente = logicControl.getPaciente(newIdPaciente);

        String fechaStr = request.getParameter("fecha");
        Date newFecha = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            newFecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tur.setFechaTurno(newFecha);
        tur.setHoraTurno(newHora);
        tur.setAfeccion(newAfeccion);
        tur.setUnOdontologo(newOdontologo);
        tur.setUnPaciente(newPaciente);

        logicControl.modificarTurno(tur);

        response.sendRedirect(request.getContextPath() + "/turnos");

    }
}