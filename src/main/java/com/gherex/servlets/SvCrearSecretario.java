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

@WebServlet(name = "SvCrearSecretario", urlPatterns = {"/admin/secretarios/crear"})
public class SvCrearSecretario extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuariosDisponibles = logicControl.getUsuarios();
        request.setAttribute("usuariosDisponibles", usuariosDisponibles);
        request.getRequestDispatcher("/altaSecretarios.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String sector = request.getParameter("sector");

        String fechaNacStr = request.getParameter("fechaNac");
        Date fechaNac = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = sdf.parse(fechaNacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String idUsuarioStr = request.getParameter("usuario");
        int idUsuario = Integer.parseInt(idUsuarioStr);
        Usuario unUsuario = logicControl.getUsuario(idUsuario);

        logicControl.crearSecretario(nombre, apellido, dni, telefono, direccion, fechaNac, sector, unUsuario);

        response.sendRedirect(request.getContextPath() + "/secretarios");
    }


}