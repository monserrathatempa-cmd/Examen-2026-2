package mx.sauap.persistencia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import mx.sauap.entidad.ConsultaDeLasAsignacionPK;
import java.util.List;


public class AsignacionDAO {

    public void guardar(ConsultaDeLasAsignacionPK profesor){
    Transaction tx = null;
    try (Session session = mx.sauap.persistencia.HibernateUtil.getSessionFactory().openSession()) {
        tx = session.beginTransaction();
        session.persist(profesor);
        tx.commit();
    } catch (exeption e) {
       if(tx != null) tx.rollback();
       throw e;
    }
}
public List<ConsultaDeLasAsignacionPK> obtenerTodosOrdenados(){
    try (Session session = hibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("FROM profesorUA p ORDER BY p.nombreProfesor ASC", ConsultaDeLasAsignacionPK.class)

    }
 }
}
