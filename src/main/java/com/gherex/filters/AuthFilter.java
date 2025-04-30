package com.gherex.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false); // intenta obtener la sesión actual, pero sin crear una nueva si no existe

        String uri = request.getRequestURI();
        String context = request.getContextPath();
        boolean isLoggedIn = session != null && session.getAttribute("usuario") != null;

        // EXCLUSIÓN de recursos estáticos
        boolean isStaticResource = uri.startsWith(context + "/css") ||
                uri.startsWith(context + "/js") ||
                uri.startsWith(context + "/vendor") ||
                uri.startsWith(context + "/images") ||
                uri.endsWith(".png") || uri.endsWith(".jpg") ||
                uri.endsWith(".jpeg") || uri.endsWith(".webp") ||
                uri.endsWith(".gif") || uri.endsWith(".ico") ||
                uri.endsWith(".ttf") || uri.endsWith(".woff2") ||
                uri.endsWith(".svg");

        // EXCLUSIÓN de páginas públicas
        boolean isLoginRequest = uri.equals(context + "/login");
        boolean isSinLoginPage = uri.equals(context + "/sin-login");
        boolean isLoginErrorPage = uri.equals(context + "/login-error");
        boolean isInicio = uri.equals(context + "/");

        if (isLoggedIn || isLoginRequest || isLoginErrorPage || isSinLoginPage || isInicio || isStaticResource) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(context + "/sin-login");
        }
    }

    @Override
    public void destroy() {
    }
}

