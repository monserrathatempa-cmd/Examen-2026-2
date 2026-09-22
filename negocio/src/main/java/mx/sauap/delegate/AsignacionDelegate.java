package mx.sauap.delegate;

import mx.sauap.entidad.ConsultaDeLasAsignacion;
import mx.sauap.persistencia.AsignacionDAO;
import java.util.List;

public class AsignacionDelegate {

    private final AsignacionDAO asignacionDAO;

    public AsignacionDelegate() {
        this.asignacionDAO = new AsignacionDAO();
    }

    public void guardarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        if (asignacion.getIdClase() == null) {
            throw new IllegalArgumentException("El ID de la clase es obligatorio.");
        }
        if (asignacion.getProfesor() == null || asignacion.getProfesor().getIdProfesor() == null) {
            throw new IllegalArgumentException("Debe asociar un profesor válido.");
        }
        if (asignacion.getUnidadDeAprendizaje() == null || asignacion.getUnidadDeAprendizaje().getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("Debe asociar una unidad de aprendizaje válida.");
        }

        boolean existe = asignacionDAO.existeClase(
                asignacion.getProfesor().getIdProfesor(),
                asignacion.getUnidadDeAprendizaje().getIdUnidadDeAprendizaje(),
                asignacion.getIdClase()
        );

        if (existe) {
            throw new IllegalStateException("Esta asignación de clase ya se encuentra registrada.");
        }

        asignacionDAO.guardar(asignacion);
    }

    public List<ConsultaDeLasAsignacion> obtenerTodasAsignaciones() {
        return asignacionDAO.obtenerTodas();
    }
}