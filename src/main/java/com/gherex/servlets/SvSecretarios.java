package com.gherex.servlets;

import com.gherex.logic.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvSecretarios", urlPatterns = {"/secretarios"})
public class SvSecretarios extends HttpServlet {

    LogicController logicControl = new LogicController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Secretario> listaSecretarios = new ArrayList<Secretario>();
        listaSecretarios = logicControl.getSecretarios();

        request.setAttribute("listaSecretarios", listaSecretarios);
        request.getRequestDispatcher("/verSecretarios.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST no permitido en esta ruta");
    }

}