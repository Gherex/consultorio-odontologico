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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvEditarPaciente", urlPatterns = {"/pacientes/editar"})
public class SvEditarPaciente extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        Paciente pac = logicControl.getPaciente(id);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("pacEdit", pac);

        response.sendRedirect("/editarPacientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente pac = (Paciente) request.getSession().getAttribute("pacEdit");

        String newNombre = request.getParameter("nombre");
        String newApellido = request.getParameter("apellido");
        String newDni = request.getParameter("dni");
        String newTelefono = request.getParameter("telefono");
        String newDireccion = request.getParameter("direccion");

        String newTieneObraSocialStr = request.getParameter("tieneObraSocial");
        boolean newTieneObraSocial;
        newTieneObraSocial = newTieneObraSocialStr.equals("Sí");

        String newTipoSangre = request.getParameter("tipoSangre");
        // String newListaTurnos = request.getParameter("listaTurnos");
        // String newResponsable = request.getParameter("responsable");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // hago los dos vacios que me faltan de momento:
        Responsable newResponsable = new Responsable();
        List<Turno> listaTurnos = new ArrayList<>();

        pac.setNombre(newNombre);
        pac.setApellido(newApellido);
        pac.setDni(newDni);
        pac.setTelefono(newTelefono);
        pac.setDireccion(newDireccion);
        pac.setFechaNacimiento(fechaNac);
        pac.setTieneObraSocial(newTieneObraSocial);
        pac.setTipoSangre(newTipoSangre);
        pac.setUnResponsable(newResponsable);
        pac.setListaTurnos(listaTurnos);

        logicControl.modificarPaciente(pac);

        response.sendRedirect(request.getContextPath() + "/pacientes");

    }
}