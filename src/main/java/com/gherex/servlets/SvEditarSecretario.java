package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Secretario;

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

@WebServlet(name = "SvEditarSecretario", urlPatterns = {"/admin/secretarios/editar"})
public class SvEditarSecretario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        Secretario sec = logicControl.getSecretario(id);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("secEdit", sec);

        response.sendRedirect("editarSecretario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Secretario sec = (Secretario) request.getSession().getAttribute("secEdit");

        String newNombre = request.getParameter("nombre");
        String newApellido = request.getParameter("apellido");
        String newDni = request.getParameter("dni");
        String newTelefono = request.getParameter("telefono");
        String newDireccion = request.getParameter("direccion");
        String newSector = request.getParameter("sector");
        // String newUsuario = request.getParameter("usuario");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sec.setNombre(newNombre);
        sec.setApellido(newApellido);
        sec.setDni(newDni);
        sec.setTelefono(newTelefono);
        sec.setDireccion(newDireccion);
        sec.setFechaNacimiento(fechaNac);
        sec.setSector(newSector);

        logicControl.modificarSecretario(sec);

        response.sendRedirect(request.getContextPath() + "/secretarios");
    }
}