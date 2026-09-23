package mx.sauap.persistencia;

import org.hibernate.Session;
import mx.sauap.entidad.admin;

public class AdminDAO {

    public admin buscarPorCredenciales(String usuario, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM admin a WHERE a.usuario = :usuario AND a.password = :password",
                            admin.class)
                    .setParameter("usuario", usuario)
                    .setParameter("password", password)
                    .uniqueResult();
        }
    }

    public boolean existeUsuario(String usuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(a) FROM admin a WHERE a.usuario = :usuario",
                            Long.class)
                    .setParameter("usuario", usuario)
                    .uniqueResult();
            return count != null && count > 0;
        }
    }
}