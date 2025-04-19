package com.jhonny.inventario.servlets;

import com.jhonny.inventario.dao.UsuarioDAO;
import com.jhonny.inventario.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // 0) Instancia tu DAO
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) Leer parámetros
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // 2) Buscar el usuario en la base de datos
        Usuario u = usuarioDAO.findByUsername(user);

        // 3) Comprobar la contraseña
        boolean valid = u != null
                && u.getContrasena() != null
                && u.getContrasena().trim().equals(pass.trim());

        // 4) Responder
        resp.setContentType("text/html;charset=UTF-8");
        if (valid) {
            // Login correcto: redirige a tu dashboard
            resp.sendRedirect("dashboard.html");
        } else {
            // Login fallido: muestra mensaje de error
            resp.getWriter().write("<h1>Usuario o contraseña incorrectos</h1>");
        }
    }
}