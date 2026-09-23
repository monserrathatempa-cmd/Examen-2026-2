package mx.sauap.ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.sauap.entidad.Asignacion;
import mx.sauap.entidad.Profesor;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.helper.AsignacionHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named("asignacionBeanUI")
@ViewScoped
public class AsignacionBeanUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private Profesor profesorSeleccionado;
    private unidadesDeAprendizaje unidadSeleccionada;
    private String periodo;

    private List<Profesor> listaProfesores;
    private List<unidadesDeAprendizaje> listaUnidades;
    private List<Asignacion> listaAsignaciones;

    private final AsignacionHelper helper = new AsignacionHelper();

    public AsignacionBeanUI() {
    }

    @PostConstruct
    public void init() {
        cargarCatalogos();
        cargarAsignaciones();
    }

    public void cargarCatalogos() {
        try {
            listaProfesores = helper.obtenerProfesores();
            listaUnidades = helper.obtenerUnidades();
        } catch (Exception e) {
            helper.mensajeError("Error al cargar catálogos", e.getMessage());
        }
    }

    public void cargarAsignaciones() {
        try {
            listaAsignaciones = helper.obtenerTodas();
        } catch (Exception e) {
            helper.mensajeError("Error al listar asignaciones", e.getMessage());
        }
    }

    public List<Profesor> buscarProfesor(String query) {
        if (listaProfesores == null) return new ArrayList<>();
        if (query == null || query.trim().isEmpty()) return listaProfesores;
        String q = query.toLowerCase().trim();
        List<Profesor> resultado = new ArrayList<>();
        for (Profesor p : listaProfesores) {
            if (contiene(p.getNombreProfesor(), q)
                    || contiene(p.getApellidoPaterno(), q)
                    || contiene(p.getApellidoMaterno(), q)
                    || contiene(p.getRfc(), q)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<unidadesDeAprendizaje> buscarUnidad(String query) {
        if (listaUnidades == null) return new ArrayList<>();
        if (query == null || query.trim().isEmpty()) return listaUnidades;
        String q = query.toLowerCase().trim();
        List<unidadesDeAprendizaje> resultado = new ArrayList<>();
        for (unidadesDeAprendizaje u : listaUnidades) {
            if (contiene(u.getNombreUDA(), q)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    private boolean contiene(String valor, String busqueda) {
        return valor != null && valor.toLowerCase().contains(busqueda);
    }

    public void guardar() {
        try {
            if (profesorSeleccionado == null) {
                helper.mensajeError("Validación", "Debe seleccionar un profesor.");
                return;
            }
            if (unidadSeleccionada == null) {
                helper.mensajeError("Validación", "Debe seleccionar una unidad.");
                return;
            }
            if (periodo == null || periodo.trim().isEmpty()) {
                helper.mensajeError("Validación", "El periodo es obligatorio.");
                return;
            }

            Asignacion asignacion = new Asignacion();
            asignacion.setProfesor(profesorSeleccionado);
            asignacion.setUnidadDeAprendizaje(unidadSeleccionada);
            asignacion.setPeriodo(periodo.trim());

            helper.guardar(asignacion);
            helper.mensajeInfo("Éxito", "Asignación registrada correctamente.");
            limpiar();
            cargarAsignaciones();
        } catch (Exception e) {
            helper.mensajeError("Error al asignar", e.getMessage());
        }
    }

    public void eliminar(Asignacion seleccionada) {
        try {
            helper.eliminar(seleccionada);
            helper.mensajeInfo("Éxito", "Asignación eliminada correctamente.");
            cargarAsignaciones();
        } catch (Exception e) {
            helper.mensajeError("Error al eliminar", e.getMessage());
        }
    }

    public void limpiar() {
        profesorSeleccionado = null;
        unidadSeleccionada = null;
        periodo = null;
    }

    public Map<Profesor, List<Asignacion>> getAsignacionesPorProfesor() {
        Map<Profesor, List<Asignacion>> mapa = new LinkedHashMap<>();
        if (listaAsignaciones == null) return mapa;
        for (Asignacion a : listaAsignaciones) {
            Profesor p = a.getProfesor();
            if (p == null) continue;
            mapa.computeIfAbsent(p, k -> new ArrayList<>()).add(a);
        }
        return mapa;
    }

    public Profesor getProfesorSeleccionado() { return profesorSeleccionado; }
    public void setProfesorSeleccionado(Profesor profesorSeleccionado) { this.profesorSeleccionado = profesorSeleccionado; }

    public unidadesDeAprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(unidadesDeAprendizaje unidadSeleccionada) { this.unidadSeleccionada = unidadSeleccionada; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public void setListaProfesores(List<Profesor> listaProfesores) { this.listaProfesores = listaProfesores; }

    public List<unidadesDeAprendizaje> getListaUnidades() { return listaUnidades; }
    public void setListaUnidades(List<unidadesDeAprendizaje> listaUnidades) { this.listaUnidades = listaUnidades; }

    public List<Asignacion> getListaAsignaciones() { return listaAsignaciones; }
    public void setListaAsignaciones(List<Asignacion> listaAsignaciones) { this.listaAsignaciones = listaAsignaciones; }
}
