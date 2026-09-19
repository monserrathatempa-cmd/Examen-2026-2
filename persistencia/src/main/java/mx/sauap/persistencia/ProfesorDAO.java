package mx.sauap.persistencia;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import mx.sauap.entidad.profesorUA;
import java.util.List;


public class AsignacionDAO {

    public void guardar(profesorUA profesor){
    Transaction tx = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        tx = session.beginTransaction();
        session.persist(profesor);
        tx.commit();
    } catch (exeption e) {
       if(tx != null) tx.rollback();
       throw e;
    }
}
public List<profesorUA> obtenerTodosOrdenados(){
    try (Session session = hibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("FROM profesorUA p ORDER BY p.nombreProfesor ASC",profesorUA.class)

    }
 }
}
