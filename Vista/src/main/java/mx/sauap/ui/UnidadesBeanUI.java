package mx.sauap.ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.helper.AdminHelper;
import mx.sauap.helper.UnidadesDeAprendizajeHelper;

import java.io.Serializable;
import java.util.List;

@Named("unidadesBeanUI")
@ViewScoped
public class UnidadesBeanUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private unidadesDeAprendizaje unidad;
    private unidadesDeAprendizaje unidadSeleccionada;
    private List<unidadesDeAprendizaje> listaUnidades;

    private boolean modoEdicion;

    private final UnidadesDeAprendizajeHelper helper = new UnidadesDeAprendizajeHelper();
    private final AdminHelper adminHelper = new AdminHelper();

    public UnidadesBeanUI() {
    }

    @PostConstruct
    public void init() {
        unidad = new unidadesDeAprendizaje();
        modoEdicion = false;
        cargarLista();
    }

    public void cargarLista() {
        try {
            listaUnidades = helper.obtenerTodas();
        } catch (Exception e) {
            helper.mensajeError("Error al listar", e.getMessage());
        }
    }

    public void guardar() {
        try {
            helper.guardar(unidad, adminHelper.obtenerAdminLogueado());
            helper.mensajeInfo("Éxito", "Unidad registrada correctamente.");
            unidad = new unidadesDeAprendizaje();
            modoEdicion = false;
            cargarLista();
        } catch (Exception e) {
            helper.mensajeError("Error al guardar", e.getMessage());
        }
    }

    public void prepararEdicion(unidadesDeAprendizaje seleccionada) {
        this.unidad = seleccionada;
        this.modoEdicion = true;
    }

    public void actualizar() {
        try {
            helper.actualizar(unidad);
            helper.mensajeInfo("Éxito", "Unidad actualizada correctamente.");
            unidad = new unidadesDeAprendizaje();
            modoEdicion = false;
            cargarLista();
        } catch (Exception e) {
            helper.mensajeError("Error al actualizar", e.getMessage());
        }
    }

    public void eliminar(unidadesDeAprendizaje seleccionada) {
        try {
            helper.eliminar(seleccionada);
            helper.mensajeInfo("Éxito", "Unidad eliminada correctamente.");
            cargarLista();
        } catch (Exception e) {
            helper.mensajeError("Error al eliminar",
                    "No se pudo eliminar la unidad: " + e.getMessage());
        }
    }

    public void cancelar() {
        unidad = new unidadesDeAprendizaje();
        modoEdicion = false;
    }

    public unidadesDeAprendizaje getUnidad() {
        return unidad;
    }

    public void setUnidad(unidadesDeAprendizaje unidad) {
        this.unidad = unidad;
    }

    public unidadesDeAprendizaje getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    public void setUnidadSeleccionada(unidadesDeAprendizaje unidadSeleccionada) {
        this.unidadSeleccionada = unidadSeleccionada;
    }

    public List<unidadesDeAprendizaje> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<unidadesDeAprendizaje> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }
}