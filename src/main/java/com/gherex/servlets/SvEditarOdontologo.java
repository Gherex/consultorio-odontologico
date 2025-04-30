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

@WebServlet(name = "SvEditarOdontologo", urlPatterns = {"/admin/odontologos/editar"})
public class SvEditarOdontologo extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> usuariosDisponibles = logicControl.getUsuarios();
        request.setAttribute("usuariosDisponibles", usuariosDisponibles);

        Integer id = Integer.parseInt(request.getParameter("id"));

        Odontologo odo = logicControl.getOdontologo(id);

        HttpSession session = request.getSession();
        session.setAttribute("odoEdit", odo);

        request.getRequestDispatcher("/editarOdontologo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Odontologo odo = (Odontologo) request.getSession().getAttribute("odoEdit");

        String newNombre = request.getParameter("nombre");
        String newApellido = request.getParameter("apellido");
        String newDni = request.getParameter("dni");
        String newTelefono = request.getParameter("telefono");
        String newDireccion = request.getParameter("direccion");
        String newEspecialidad = request.getParameter("especialidad");
        String newHoraInicio = request.getParameter("horaInicio");
        String newHoraFin = request.getParameter("horaFin");

        String newIdUsuarioStr = request.getParameter("usuario");
        int newIdUsuario = Integer.parseInt(newIdUsuarioStr);
        Usuario newUsuario = logicControl.getUsuario(newIdUsuario);

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Horario newHorario = new Horario(newHoraInicio, newHoraFin);

        odo.setNombre(newNombre);
        odo.setApellido(newApellido);
        odo.setDni(newDni);
        odo.setTelefono(newTelefono);
        odo.setDireccion(newDireccion);
        odo.setFechaNacimiento(fechaNac);
        odo.setEspecialidad(newEspecialidad);
        odo.setUnUsuario(newUsuario);
        odo.setUnHorario(newHorario);

        logicControl.modificarOdontologo(odo);

        response.sendRedirect(request.getContextPath() + "/odontologos");

    }
}