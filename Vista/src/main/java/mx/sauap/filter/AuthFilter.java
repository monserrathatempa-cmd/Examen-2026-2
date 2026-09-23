package mx.sauap.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("*.xhtml")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI().substring(req.getContextPath().length());

        boolean esLogin = path.equals("/login.xhtml");
        boolean esRecurso = path.startsWith("/jakarta.faces.resource/");
        boolean esIndex = path.equals("/") || path.equals("/index.xhtml");

        HttpSession session = req.getSession(false);
        boolean tieneSesion = (session != null && session.getAttribute("adminLogueado") != null);

        if (esLogin || esRecurso || tieneSesion || esIndex) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

    @Override
    public void destroy() {
    }
}
