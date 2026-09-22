package mx.sauap.facade;

import mx.sauap.delegate.AsignacionDelegate;
import mx.sauap.entidad.ConsultaDeLasAsignacion;
import java.util.List;

public class AsignacionFacade {

    private final AsignacionDelegate delegate;

    public AsignacionFacade() {
        this.delegate = new AsignacionDelegate();
    }

    public void guardarAsignacion(ConsultaDeLasAsignacion asignacion) throws Exception {
        delegate.guardarAsignacion(asignacion);
    }

    public List<ConsultaDeLasAsignacion> obtenerTodasAsignaciones() {
        return delegate.obtenerTodasAsignaciones();
    }
}