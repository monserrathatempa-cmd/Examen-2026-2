package mx.sauap.equipo10.delegate;

import UnApDAO;
import mx.sauap.entidad.unidadesDeAprendizaje;
import java.util.List;

public class DelegateUnidadesDeAprendizaje {

    private final UnApDAO unApDAO;

    public DelegateUnidadesDeAprendizaje() {
        this.unApDAO = new UnApDAO();
    }

    public void guardarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null) {
            throw new Exception("La unidad de aprendizaje no puede ser nula.");
        }
        if (unidad.getHoraC() < 0 || unidad.getHoraC() > 4 ||
                unidad.getHoraT() < 0 || unidad.getHoraT() > 4 ||
                unidad.getHoraL() < 0 || unidad.getHoraL() > 4) {
            throw new Exception("Las horas de clase, taller o laboratorio deben estar entre 0 y 4.");
        }
        unApDAO.guardar(unidad);
    }

    public void actualizarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null || unidad.getIdUnidadDeAprendizaje() == null) {
            throw new Exception("No se puede actualizar una unidad inexistente.");
        }
        unApDAO.actualizar(unidad);
    }

    public void eliminarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null || unidad.getIdUnidadDeAprendizaje() == null) {
            throw new Exception("No se puede eliminar la unidad especificada.");
        }
        unApDAO.eliminar(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodasUnidades() {
        return unApDAO.obtenerTodos();
    }

    public unidadesDeAprendizaje buscarUnidadPorId(Integer id) {
        if (id == null) return null;
        return unApDAO.buscarPorId(id);
    }
}