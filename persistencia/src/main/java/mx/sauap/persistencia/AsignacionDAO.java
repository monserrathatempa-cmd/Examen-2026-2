package mx.sauap.persistencia;

import mx.sauap.entidad.Asignacion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AsignacionDAO {

    public void guardar(Asignacion asignacion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(asignacion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void eliminar(Asignacion asignacion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(session.contains(asignacion) ? asignacion : session.merge(asignacion));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Asignacion> obtenerTodas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Asignacion a " +
                                    "ORDER BY a.profesor.nombreProfesor ASC, a.periodo ASC",
                            Asignacion.class)
                    .getResultList();
        }
    }

    public boolean existeAsignacion(Integer idProfesor, Integer idUnidad, String periodo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(a) FROM Asignacion a " +
                                    "WHERE a.profesor.idProfesor = :idProfesor " +
                                    "AND a.unidadDeAprendizaje.idUnidadDeAprendizaje = :idUnidad " +
                                    "AND a.periodo = :periodo",
                            Long.class)
                    .setParameter("idProfesor", idProfesor)
                    .setParameter("idUnidad", idUnidad)
                    .setParameter("periodo", periodo)
                    .uniqueResult();
            return count != null && count > 0;
        }
    }
}