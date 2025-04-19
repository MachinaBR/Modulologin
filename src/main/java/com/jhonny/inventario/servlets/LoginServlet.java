package com.jhonny.inventario.servlets;

import com.jhonny.inventario.dao.UsuarioDAO;
import com.jhonny.inventario.model.Usuario;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        Usuario u = usuarioDAO.findByUsername(user);
        if (u != null && u.getContrasena().equals(pass)) {
            // logueo exitoso
            resp.sendRedirect("dashboard.html");
        } else {
            req.setAttribute("error", "Usuario o contraseña incorrectos");
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
    }
}