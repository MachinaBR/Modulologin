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
        if (u == null) {
            req.setAttribute("userError", "Usuario no encontrado");
            req.setAttribute("usernameValue", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        // 2) Contraseña mal
        if (!u.getContrasena().trim().equals(pass.trim())) {
            req.setAttribute("passError", "Contraseña incorrecta");
            req.setAttribute("usernameValue", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/dashboard.html");

    }
}