package com.gherex.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminRoleFilter", urlPatterns = {"/admin/*"})
public class AdminRoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("rol") != null) {
            String rol = (String) session.getAttribute("rol");

            if ("Admin".equals(rol)) {
                // usuario autorizado
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        // Si no es admin o no hay sesión, redirigir a página de acceso denegado
        response.sendRedirect(request.getContextPath() + "/acceso-denegado");

    }

    @Override
    public void destroy() {
    }
}
