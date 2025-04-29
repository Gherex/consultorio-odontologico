package com.gherex.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("usuario") != null;
        String uri = request.getRequestURI();
        String context = request.getContextPath();

        boolean isLoginRequest = uri.equals(context + "/login");
        boolean isSinLoginPage = uri.equals(context + "/sin-login");
        boolean isLoginErrorPage = uri.equals(context + "/login-error");
        boolean isInicio = uri.equals(context + "/");

        if (isLoggedIn || isLoginRequest || isLoginErrorPage || isSinLoginPage || isInicio) {
            chain.doFilter(request, response); // dejar pasar
        } else {
            response.sendRedirect(context + "/sin-login");
        }
    }

    @Override
    public void destroy() {
    }
}

