package com.jhonny.inventario.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HolaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h1>¡Hola desde el Servlet!</h1>");
    }
}