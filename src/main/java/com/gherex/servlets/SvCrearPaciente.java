package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.utils.DateUtils;

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

@WebServlet(name = "SvCrearPaciente", urlPatterns = {"/admin/pacientes/crear"})
public class SvCrearPaciente extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/altaPacientes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        String tieneObraSocialStr = request.getParameter("tieneObraSocial");
        boolean tieneObraSocial = Boolean.parseBoolean(tieneObraSocialStr);

        String tipoSangre = request.getParameter("tipoSangre");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int edad = DateUtils.calcularEdad(fechaNac);

        if (edad >= 18) {
            logicControl.crearPaciente(nombre, apellido, dni, telefono, direccion, fechaNac, tieneObraSocial, tipoSangre, null);
            response.sendRedirect(request.getContextPath() + "/pacientes");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("nombrePaciente", nombre);
            session.setAttribute("apellidoPaciente", apellido);
            session.setAttribute("dniPaciente", dni);
            session.setAttribute("telefonoPaciente", telefono);
            session.setAttribute("direccionPaciente", direccion);
            session.setAttribute("fechaNacimientoPaciente", fechaNac);
            session.setAttribute("tieneObraSocialPaciente", tieneObraSocial);
            session.setAttribute("tipoSangrePaciente", tipoSangre);

            response.sendRedirect(request.getContextPath() + "/admin/responsables/crear");
        }

    }
}
