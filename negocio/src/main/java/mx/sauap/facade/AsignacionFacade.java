package mx.sauap.facade;

import mx.sauap.delegate.AsignacionDelegate;
import mx.sauap.entidad.Asignacion;

import java.util.List;

public class AsignacionFacade {

    private final AsignacionDelegate delegate;

    public AsignacionFacade() {
        this.delegate = new AsignacionDelegate();
    }

    public void guardarAsignacion(Asignacion asignacion) throws Exception {
        delegate.guardarAsignacion(asignacion);
    }

    public void eliminarAsignacion(Asignacion asignacion) throws Exception {
        delegate.eliminarAsignacion(asignacion);
    }

    public List<Asignacion> obtenerTodasAsignaciones() {
        return delegate.obtenerTodasAsignaciones();
    }
}