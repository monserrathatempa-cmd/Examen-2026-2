package mx.sauap.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import mx.sauap.entidad.Profesor;
import java.util.List;

public class ProfesorDAO {

    public void guardar(Profesor profesor) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(profesor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Profesor> obtenerTodosOrdenados() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Profesor p ORDER BY p.nombreProfesor ASC", Profesor.class).list();
        }
    }
}