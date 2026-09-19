package mx.sauap.equipo10.delegate;

import AsignacionDAO;
import mx.sauap.entidad.ConsultaDeLasAsignacion;
import java.util.List;

public class DelegateAsignacion {

    private final AsignacionDAO asignacionDAO;

    public DelegateAsignacion() {
        this.asignacionDAO = new AsignacionDAO();
    }

    public void guardarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        if (asignacion == null) {
            throw new Exception("La asignación no puede ser nula.");
        }
        if (asignacion.getProfesor() == null || asignacion.getUnidadDeAprendizaje() == null) {
            throw new Exception("Debe seleccionar un profesor y una unidad de aprendizaje válidos.");
        }
        asignacionDAO.guardar(asignacion);
    }

    public void eliminarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        if (asignacion == null) {
            throw new Exception("No se puede eliminar la asignación especificada.");
        }
        asignacionDAO.eliminar(asignacion);
    }

    public List<ConsultaDeLasAsignacion> obtenerTodasAsignaciones() {
        return asignacionDAO.obtenerTodos();
    }
}