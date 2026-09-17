package mx.Examen2026.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.Examen2026.entity.UnidadesDeAprendizaje;
import mx.Examen2026.persistence.persistence.AbstractDAO;


import java.util.List;


public class UnidadDAO extends AbstractDAO<UnidadesDeAprendizaje> {
    private final EntityManager entityManager;

    public UnidadDAO(EntityManager em) {
        super(UnidadesDeAprendizaje.class);
        this.entityManager = em;
    }

    public List<UnidadesDeAprendizaje> obtenerTodos(){
        return entityManager
                .createQuery("SELECT u FROM UnidadesDeAprendizaje u", UnidadesDeAprendizaje.class)
                .getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
