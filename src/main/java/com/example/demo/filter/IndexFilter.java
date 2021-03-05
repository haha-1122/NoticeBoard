package com.example.demo.filter;

import com.example.demo.model.DB;

import javax.ejb.SessionContext;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/index.jsp")
public class IndexFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        DB db = new DB(request, response);
        ServletContext application = request.getServletContext();
        application.setAttribute("repository", db.repository());
        chain.doFilter(request, response);
    }
}
