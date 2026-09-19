package mx.sauap.equipo10.facade;

import mx.sauap.equipo10.delegate.DelegateUnidadesDeAprendizaje;
import mx.sauap.entidad.unidadesDeAprendizaje;
import java.util.List;

public class FacadeUnidadesDeAprendizaje {

    private final DelegateUnidadesDeAprendizaje delegateUnidades;

    public FacadeUnidadesDeAprendizaje() {
        this.delegateUnidades = new DelegateUnidadesDeAprendizaje();
    }

    public void guardarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegateUnidades.guardarUnidad(unidad);
    }

    public void actualizarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegateUnidades.actualizarUnidad(unidad);
    }

    public void eliminarUnidad(unidadesDeAprendizaje unidad) throws Exception {
        delegateUnidades.eliminarUnidad(unidad);
    }

    public List<unidadesDeAprendizaje> obtenerTodasUnidades() {
        return delegateUnidades.obtenerTodasUnidades();
    }

    public unidadesDeAprendizaje buscarUnidadPorId(Integer id) {
        return delegateUnidades.buscarUnidadPorId(id);
    }
}
