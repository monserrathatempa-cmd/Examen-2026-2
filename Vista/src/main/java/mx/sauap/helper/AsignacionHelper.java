package mx.sauap.helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.sauap.entidad.Asignacion;
import mx.sauap.entidad.Profesor;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.facade.AsignacionFacade;
import mx.sauap.facade.ProfesorFacade;
import mx.sauap.facade.UnidadesDeAprendizajeFacade;
import mx.sauap.integration.ServiceFacadeLocator;

import java.util.List;

/**
 * Helper de asignaciones y consultas.
 * Coordina los tres facades: asignación, profesor y unidades.
 */
public class AsignacionHelper {

    private final AsignacionFacade asignacionFacade;
    private final ProfesorFacade profesorFacade;
    private final UnidadesDeAprendizajeFacade unidadesFacade;

    public AsignacionHelper() {
        this.asignacionFacade = ServiceFacadeLocator.getInstanceFacadeAsignacion();
        this.profesorFacade = ServiceFacadeLocator.getInstanceFacadeProfesor();
        this.unidadesFacade = ServiceFacadeLocator.getInstanceFacadeUnidadesDeAprendizaje();
    }

    public void guardar(Asignacion asignacion) throws Exception {
        // El delegate hace las validaciones (incluida la de traslape)
        asignacionFacade.guardarAsignacion(asignacion);
    }

    public void eliminar(Asignacion asignacion) throws Exception {
        asignacionFacade.eliminarAsignacion(asignacion);
    }

    public List<Asignacion> obtenerTodas() {
        return asignacionFacade.obtenerTodasAsignaciones();
    }

    public List<Profesor> obtenerProfesores() {
        return profesorFacade.obtenerTodosProfesores();
    }

    public List<unidadesDeAprendizaje> obtenerUnidades() {
        return unidadesFacade.obtenerTodasUnidades();
    }

    public void mensajeError(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle));
    }

    public void mensajeInfo(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }
}