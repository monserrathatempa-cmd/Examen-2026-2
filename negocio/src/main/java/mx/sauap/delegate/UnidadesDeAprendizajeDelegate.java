package mx.sauap.delegate;

import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.persistencia.UnidadesDeAprendizajeDAO;
import java.util.List;

public class UnidadesDeAprendizajeDelegate {

    private final UnidadesDeAprendizajeDAO unidadesDAO;

    public UnidadesDeAprendizajeDelegate() {
        this.unidadesDAO = new UnidadesDeAprendizajeDAO();
    }

    public void guardarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        validarUnidad(unidad);
        unidadesDAO.guardar(unidad);
    }

    public void actualizarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("El ID de la unidad es requerido para actualizar.");
        }
        validarUnidad(unidad);
        unidadesDAO.actualizar(unidad);
    }

    public void eliminarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null || unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("La unidad a eliminar no es válida.");
        }
        unidadesDAO.eliminar(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodasUnidades() {
        return unidadesDAO.obtenerTodas();
    }

    private void validarUnidad(unidadesDeAprendizaje unidad) {
        if (unidad == null) {
            throw new IllegalArgumentException("La unidad no puede ser nula.");
        }
        if (unidad.getNombreUDA() == null || unidad.getNombreUDA().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la unidad es obligatorio.");
        }
        if (unidad.getNombreUDA().length() > 50) {
            throw new IllegalArgumentException("El nombre no puede exceder 50 caracteres.");
        }
        validarHoras(unidad.getHoraC(), "Horas clase");
        validarHoras(unidad.getHoraT(), "Horas taller");
        validarHoras(unidad.getHoraL(), "Horas laboratorio");
    }

    private void validarHoras(Integer horas, String campo) {
        if (horas == null) {
            throw new IllegalArgumentException(campo + " es obligatorio.");
        }
        if (horas < 0 || horas > 4) {
            throw new IllegalArgumentException(campo + " debe estar entre 0 y 4.");
        }
    }
}