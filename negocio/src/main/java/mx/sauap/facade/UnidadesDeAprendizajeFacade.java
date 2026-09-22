package mx.sauap.facade;

import mx.sauap.delegate.UnidadesDeAprendizajeDelegate;
import mx.sauap.entidad.unidadesDeAprendizaje;
import java.util.List;

public class UnidadesDeAprendizajeFacade {

    private final UnidadesDeAprendizajeDelegate delegate;

    public UnidadesDeAprendizajeFacade() {
        this.delegate = new UnidadesDeAprendizajeDelegate();
    }

    public void guardarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegate.guardarUnidad(unidad);
    }

    public void actualizarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegate.actualizarUnidad(unidad);
    }

    public void eliminarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegate.eliminarUnidad(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodasUnidades() {
        return delegate.obtenerTodasUnidades();
    }
}