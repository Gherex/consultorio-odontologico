package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Paciente;
import com.gherex.logic.Responsable;
import com.gherex.logic.Turno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        listaPacientes = logicControl.getPacientes();

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaPacientes", listaPacientes);

        response.sendRedirect("verPacientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        String tieneObraSocialStr = request.getParameter("tieneObraSocial");
        boolean tieneObraSocial;
        tieneObraSocial = tieneObraSocialStr.equals("Sí");

        String tipoSangre = request.getParameter("tipoSangre");
        // String responsable = request.getParameter("responsable");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // de momento voy a crear lo que falta vacío:
        Responsable responsable = new Responsable();
        List<Turno> listaTurnos = new ArrayList<>();

        logicControl.crearPaciente(nombre, apellido, dni, telefono, direccion, fechaNac, tieneObraSocial, tipoSangre, responsable, listaTurnos);

        response.sendRedirect("SvPacientes");
    }
}