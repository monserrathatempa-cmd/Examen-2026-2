package mx.sauap.delegate;

import mx.sauap.entidad.admin;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.persistencia.UnidadesDeAprendizajeDAO;
import java.util.List;

public class UnidadesDeAprendizajeDelegate {

    private final UnidadesDeAprendizajeDAO unidadesDAO;

    public UnidadesDeAprendizajeDelegate() {
        this.unidadesDAO = new UnidadesDeAprendizajeDAO();
    }

    public void guardarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad.getNombreUDA() == null || unidad.getNombreUDA().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la unidad de aprendizaje es obligatorio.");
        }
        if (unidad.getAdministrador() == null) {
            admin adminDefault = new admin();
            adminDefault.setIdAdmin(1);
            unidad.setAdministrador(adminDefault);
        }
        unidadesDAO.guardar(unidad);
    }

    public void actualizarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("El ID de la unidad es requerido para actualizar.");
        }
        unidadesDAO.actualizar(unidad);
    }

    public void eliminarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("El ID de la unidad es requerido para eliminar.");
        }
        unidadesDAO.eliminar(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodasUnidades() {
        return unidadesDAO.obtenerTodas();
    }
}