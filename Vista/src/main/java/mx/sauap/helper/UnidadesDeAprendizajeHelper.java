package mx.sauap.helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.sauap.entidad.admin;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.facade.UnidadesDeAprendizajeFacade;
import mx.sauap.integration.ServiceFacadeLocator;

import java.util.List;

/**
 * Helper de Unidades de Aprendizaje.
 * Encapsula el acceso al facade y el manejo de mensajes.
 */
public class UnidadesDeAprendizajeHelper {

    private final UnidadesDeAprendizajeFacade facade;

    public UnidadesDeAprendizajeHelper() {
        this.facade = ServiceFacadeLocator.getInstanceFacadeUnidadesDeAprendizaje();
    }

    public void guardar(unidadesDeAprendizaje unidad, admin adminLogueado) throws Exception {
        if (unidad == null) {
            throw new IllegalArgumentException("La unidad no puede ser nula.");
        }
        if (adminLogueado == null) {
            throw new IllegalStateException(
                    "No hay administrador en sesión. Vuelva a iniciar sesión.");
        }
        // Se setea el admin logueado porque es NOT NULL en BD
        unidad.setAdministrador(adminLogueado);
        facade.guardarUnidad(unidad);
    }

    public void actualizar(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null || unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("Debe seleccionar una unidad para actualizar.");
        }
        facade.actualizarUnidad(unidad);
    }

    public void eliminar(unidadesDeAprendizaje unidad) throws Exception {
        if (unidad == null || unidad.getIdUnidadDeAprendizaje() == null) {
            throw new IllegalArgumentException("Debe seleccionar una unidad para eliminar.");
        }
        facade.eliminarUnidad(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodas() {
        return facade.obtenerTodasUnidades();
    }

    public void mensajeError(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle));
    }

    public void mensajeInfo(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }

    public void mensajeWarn(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, resumen, detalle));
    }
}