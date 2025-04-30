package com.gherex.servlets;

import com.gherex.logic.LogicController;
import com.gherex.logic.Secretario;
import com.gherex.logic.Usuario;

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

@WebServlet(name = "SvEditarSecretario", urlPatterns = {"/admin/secretarios/editar"})
public class SvEditarSecretario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> usuariosDisponibles = logicControl.getUsuarios();
        request.setAttribute("usuariosDisponibles", usuariosDisponibles);

        Integer id = Integer.parseInt(request.getParameter("id"));

        Secretario sec = logicControl.getSecretario(id);

        HttpSession session = request.getSession();
        session.setAttribute("secEdit", sec);

        request.getRequestDispatcher("/editarSecretario.jsp").forward(request, response);
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

        sec.setNombre(newNombre);
        sec.setApellido(newApellido);
        sec.setDni(newDni);
        sec.setTelefono(newTelefono);
        sec.setDireccion(newDireccion);
        sec.setFechaNacimiento(fechaNac);
        sec.setSector(newSector);
        sec.setUnUsuario(newUsuario);

        logicControl.modificarSecretario(sec);

        response.sendRedirect(request.getContextPath() + "/secretarios");
    }
}