package mx.Examen2026.persistence.dao;


import jakarta.persistence.EntityManager;
import mx.Examen2026.entity.Profesor;
import mx.Examen2026.persistence.persistence.AbstractDAO;

import java.util.List;


public class ProfesorDAO extends AbstractDAO<Profesor> {
    private final EntityManager entityManager;

    public ProfesorDAO(EntityManager em) {
        super(Profesor.class);
        this.entityManager = em;
    }

    public List<Profesor> obtenerTodos(){
        return entityManager
                .createQuery("SELECT p FROM Profesor p", Profesor.class)
                .getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
