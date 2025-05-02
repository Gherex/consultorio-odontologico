package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SvCrearOdontologo", urlPatterns = {"/admin/odontologos/crear"})
public class SvCrearOdontologo extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuariosDisponibles = logicControl.getUsuarios();
        request.setAttribute("usuariosDisponibles", usuariosDisponibles);
        request.getRequestDispatcher("/altaOdontologos.jsp").forward(request, response);
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
        String especialidad = request.getParameter("especialidad");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String horaInicio = request.getParameter("horaInicio");
        String horaFin = request.getParameter("horaFin");

        String idUsuarioStr = request.getParameter("usuario");
        int idUsuario = Integer.parseInt(idUsuarioStr);
        Usuario unUsuario = logicControl.getUsuario(idUsuario);

        logicControl.crearOdontologo(nombre, apellido, dni, telefono, direccion, fechaNac, especialidad, unUsuario, horaInicio, horaFin);

        response.sendRedirect(request.getContextPath() + "/odontologos");
    }

}
