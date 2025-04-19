package com.jhonny.inventario.dao;


import com.jhonny.inventario.model.Usuario;
import com.jhonny.inventario.util.HibernateUtil;
import org.hibernate.Session;

public class UsuarioDAO {
    /** Busca un usuario por su campo 'usuario' */
    public Usuario findByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Usuario WHERE usuario = :user", Usuario.class)
                    .setParameter("user", username)
                    .uniqueResult();
        }
    }
}