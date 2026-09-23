package mx.sauap.delegate;

import mx.sauap.entidad.Asignacion;
import mx.sauap.persistencia.AsignacionDAO;

import java.util.List;

public class AsignacionDelegate {

    private final AsignacionDAO asignacionDAO;

    public AsignacionDelegate() {
        this.asignacionDAO = new AsignacionDAO();
    }

    public void guardarAsignacion(Asignacion asignacion) throws Exception {
        if (asignacion.getProfesor() == null
                || asignacion.getProfesor().getIdProfesor() == null) {
            throw new IllegalArgumentException("Debe seleccionar un profesor.");
        }
        if (asignacion.getUnidadDeAprendizaje() == null
                || asignacion.getUnidadDeAprendizaje().getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("Debe seleccionar una unidad de aprendizaje.");
        }
        if (asignacion.getPeriodo() == null || asignacion.getPeriodo().trim().isEmpty()) {
            throw new IllegalArgumentException("El periodo es obligatorio.");
        }

        String periodo = asignacion.getPeriodo().trim();

        boolean existe = asignacionDAO.existeAsignacion(
                asignacion.getProfesor().getIdProfesor(),
                asignacion.getUnidadDeAprendizaje().getIdUnidadDeAprendizaje(),
                periodo
        );

        if (existe) {
            throw new IllegalStateException(
                    "Traslape detectado: esta unidad ya está asignada al profesor " +
                            "en el periodo " + periodo + ".");
        }

        asignacion.setPeriodo(periodo);
        asignacionDAO.guardar(asignacion);
    }

    public void eliminarAsignacion(Asignacion asignacion) throws Exception {
        if (asignacion == null || asignacion.getIdAsignacion() == null) {
            throw new IllegalArgumentException("La asignación a eliminar no es válida.");
        }
        asignacionDAO.eliminar(asignacion);
    }

    public List<Asignacion> obtenerTodasAsignaciones() {
        return asignacionDAO.obtenerTodas();
    }
}