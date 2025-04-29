package com.gherex.servlets;

import com.gherex.logic.Horario;
import com.gherex.logic.LogicController;
import com.gherex.logic.Turno;
import com.gherex.logic.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvCrearOdontologo", urlPatterns = {"/admin/odontologos/crear"})
public class SvCrearOdontologo extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/altaOdontologos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // de momento voy a crear lo que falta vacío:
        Usuario unUsuario = new Usuario();
        Horario unHorario = new Horario();
        List<Turno> listaTurnos = new ArrayList<>();

        logicControl.crearOdontologo(nombre, apellido, dni, telefono, direccion, fechaNac, especialidad, listaTurnos, unUsuario, unHorario);

        response.sendRedirect(request.getContextPath() + "/odontologos");
    }

}
