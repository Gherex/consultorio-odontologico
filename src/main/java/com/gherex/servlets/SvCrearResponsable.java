package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Responsable;

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

@WebServlet(name = "SvCrearResponsable", urlPatterns = {"/admin/responsables/crear"})
public class SvCrearResponsable extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/altaResponsables.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resNombre = request.getParameter("nombre");
        String resApellido = request.getParameter("apellido");
        String resDni = request.getParameter("dni");
        String resTelefono = request.getParameter("telefono");
        String resDireccion = request.getParameter("direccion");
        String resFechaNacStr = request.getParameter("fechaNac");
        String tipoResponsabilidad = request.getParameter("responsabilidad");
        Date resFechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            resFechaNac = sdf.parse(resFechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        String pacNombre = (String) session.getAttribute("nombrePaciente");
        String pacApellido = (String) session.getAttribute("apellidoPaciente");
        String pacDni = (String) session.getAttribute("dniPaciente");
        String pacTelefono = (String) session.getAttribute("telefonoPaciente");
        String pacDireccion = (String) session.getAttribute("direccionPaciente");
        boolean tieneObraSocial = (boolean) session.getAttribute("tieneObraSocialPaciente");
        Date fechaNacimiento = (Date) session.getAttribute("fechaNacimientoPaciente");
        String pacTipoSangre = (String) session.getAttribute("tipoSangrePaciente");

        Responsable responsable = new Responsable(resDni, resNombre, resApellido, resTelefono, resDireccion, resFechaNac, tipoResponsabilidad);
        logicControl.crearResponsable(responsable);
        logicControl.crearPaciente(pacNombre, pacApellido, pacDni, pacTelefono, pacDireccion, fechaNacimiento, tieneObraSocial, pacTipoSangre, responsable);

        response.sendRedirect(request.getContextPath() + "/pacientes");
    }
}