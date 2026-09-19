package mx.sauap.persistencia;

import mx.sauap.entidad.ConsultaDeLasAsignacion;
import mx.sauap.entidad.ConsultaDeLasAsignacionPK;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class AsignacionDAO {

    public void guardar(ConsultaDeLasAsignacion asignacion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(asignacion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

    public List<ConsultaDeLasAsignacion> obtenerTodas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ConsultaDeLasAsignacion", ConsultaDeLasAsignacion.class).list();
        }
    }

    public boolean existeClase(Integer idProfesor, Integer idUnidad, Integer idClase) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(a) FROM ConsultaDeLasAsignacion a " +
                    "WHERE a.profesor.idProfesor = :idProf " +
                    "AND a.unidadDeAprendizaje.idUnidadDeAprendizaje = :idUnidad " +
                    "AND a.idClase = :idClase";

            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idProf", idProfesor);
            query.setParameter("idUnidad", idUnidad);
            query.setParameter("idClase", idClase);

            Long count = query.getSingleResult();
            return count > 0;
        }
    }
}