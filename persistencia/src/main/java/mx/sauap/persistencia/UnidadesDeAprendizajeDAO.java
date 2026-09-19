package mx.sauap.persistencia;

import mx.sauap.entidad.unidadesDeAprendizaje;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
//UNIDAD DE APRENDIZAJE
public class UnidadesDeAprendizajeDAO {

    public void guardar(unidadesDeAprendizaje unidad) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(unidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void actualizar(unidadesDeAprendizaje unidad) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(unidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void eliminar(unidadesDeAprendizaje unidad) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(session.contains(unidad) ? unidad : session.merge(unidad));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<unidadesDeAprendizaje> obtenerTodas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM unidadesDeAprendizaje", unidadesDeAprendizaje.class).getResultList();
        }
    }
}
