import mx.Examen2026.entity.Administrador;
import mx.Examen2026.entity.Profesor;
import mx.Examen2026.entity.UnidadesDeAprendizaje;
import mx.Examen2026.persistence.dao.AdministradorDAO;
import mx.Examen2026.persistence.dao.ProfesorDAO;
import mx.Examen2026.persistence.dao.UnidadDAO;
import mx.Examen2026.persistence.persistence.HibernateUtil;

public class testDAO {

    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO(HibernateUtil.getEntityManager());
        UnidadDAO unidadDAO = new UnidadDAO(HibernateUtil.getEntityManager());
        AdministradorDAO administradorDAO = new AdministradorDAO(HibernateUtil.getEntityManager());



        for (Profesor profesor : profesorDAO.findAll()) {
            System.out.println(profesor + "|| id [" + profesor.getId()+ "]");
        }

        for (Administrador administrador : administradorDAO.findAll()) {
            System.out.println(administrador + "|| id [" + administrador.getId()+ "]");
        }

        for (UnidadesDeAprendizaje unidad : unidadDAO.findAll()) {
            System.out.println(unidad + "|| id [" + unidad.getId()+ "]");
        }
    }
}
