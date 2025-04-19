package com.jhonny.inventario.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) Leer parámetros
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // 2) Validación básica (luego conectarás con tu DAO/Hibernate)
        boolean valid = "admin".equals(user) && "1234".equals(pass);

        resp.setContentType("text/html;charset=UTF-8");
        if (valid) {
            resp.getWriter().write("<h1>¡Bienvenido, " + user + "!</h1>");
        } else {
            resp.getWriter().write("<h1>Credenciales inválidas</h1>");
        }
    }
}
