package mx.sauap.persistencia;

import mx.sauap.entidad.ConsultaDeLasAsignacion;
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

    public void actualizar(ConsultaDeLasAsignacion asignacion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(asignacion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void eliminar(ConsultaDeLasAsignacion asignacion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(session.contains(asignacion) ? asignacion : session.merge(asignacion));
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
            return session.createQuery("FROM ConsultaDeLasAsignacion", ConsultaDeLasAsignacion.class).getResultList();
        }
    }

    public List<ConsultaDeLasAsignacion> obtenerPorProfesor(Integer idProfesor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ConsultaDeLasAsignacion a WHERE a.profesor.idProfesor = :idProf";
            Query<ConsultaDeLasAsignacion> query = session.createQuery(hql, ConsultaDeLasAsignacion.class);
            query.setParameter("idProf", idProfesor);
            return query.getResultList();
        }
    }

    public boolean existeTraslapeHorario(Integer idProfesor, String dia, String horaInicio, String horaFin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(a) FROM ConsultaDeLasAsignacion a " +
                    "WHERE a.profesor.idProfesor = :idProf " +
                    "AND a.dia = :dia " +
                    "AND ((:horaInicio >= a.horaInicio AND :horaInicio < a.horaFin) OR " +
                    "     (:horaFin > a.horaInicio AND :horaFin <= a.horaFin) OR " +
                    "     (a.horaInicio >= :horaInicio AND a.horaInicio < :horaFin))";

            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idProf", idProfesor);
            query.setParameter("dia", dia);
            query.setParameter("horaInicio", horaInicio);
            query.setParameter("horaFin", horaFin);

            Long count = query.getSingleResult();
            return count > 0;
        }
    }
}