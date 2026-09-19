package mx.sauap.equipo10.facade;

import mx.sauap.equipo10.delegate.DelegateAsignacion;
import mx.sauap.entidad.ConsultaDeLasAsignacion;
import java.util.List;

public class FacadeAsignacion {

    private final DelegateAsignacion delegateAsignacion;

    public FacadeAsignacion() {
        this.delegateAsignacion = new DelegateAsignacion();
    }

    public void guardarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        delegateAsignacion.guardarAsignacion(asignacion);
    }

    public void eliminarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        delegateAsignacion.eliminarAsignacion(asignacion);
    }

    public List<ConsultaDeLasAsignacion> obtenerTodasAsignaciones() {
        return delegateAsignacion.obtenerTodasAsignaciones();
    }
}