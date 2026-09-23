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

/**
 * Bean de la pantalla de asignaciones.
 * Cubre:
 *   - Alta de asignación con validación de traslape
 *   - Consulta general agrupada por profesor
 *
 * Los dropdowns usan IDs enteros para evitar problemas con converters.
 */
@Named("asignacionBeanUI")
@ViewScoped
public class AsignacionBeanUI implements Serializable {

    private static final long serialVersionUID = 1L;

    // Campos del formulario de alta
    private Integer idProfesorSeleccionado;
    private Integer idUnidadSeleccionada;
    private String periodo;

    // Catálogos
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

    /**
     * Guarda la asignación. Construye la entidad a partir de los IDs seleccionados.
     * El delegate valida traslape y lanza excepción si existe.
     */
    public void guardar() {
        try {
            if (idProfesorSeleccionado == null) {
                helper.mensajeError("Validación", "Debe seleccionar un profesor.");
                return;
            }
            if (idUnidadSeleccionada == null) {
                helper.mensajeError("Validación", "Debe seleccionar una unidad.");
                return;
            }
            if (periodo == null || periodo.trim().isEmpty()) {
                helper.mensajeError("Validación", "El periodo es obligatorio.");
                return;
            }

            Profesor profesor = buscarProfesor(idProfesorSeleccionado);
            unidadesDeAprendizaje unidad = buscarUnidad(idUnidadSeleccionada);

            if (profesor == null || unidad == null) {
                helper.mensajeError("Error", "Profesor o unidad no encontrados.");
                return;
            }

            Asignacion asignacion = new Asignacion();
            asignacion.setProfesor(profesor);
            asignacion.setUnidadDeAprendizaje(unidad);
            asignacion.setPeriodo(periodo.trim());

            helper.guardar(asignacion);
            helper.mensajeInfo("Éxito", "Asignación registrada correctamente.");
            limpiar();
            cargarAsignaciones();
        } catch (Exception e) {
            // Aquí caen los errores de traslape del delegate
            helper.mensajeError("Error al asignar", e.getMessage());
        }
    }

    /**
     * Elimina una asignación.
     */
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
        idProfesorSeleccionado = null;
        idUnidadSeleccionada = null;
        periodo = null;
    }

    private Profesor buscarProfesor(Integer id) {
        if (listaProfesores == null) return null;
        return listaProfesores.stream()
                .filter(p -> p.getIdProfesor().equals(id))
                .findFirst().orElse(null);
    }

    private unidadesDeAprendizaje buscarUnidad(Integer id) {
        if (listaUnidades == null) return null;
        return listaUnidades.stream()
                .filter(u -> u.getIdUnidadDeAprendizaje().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * Agrupa las asignaciones por profesor para la consulta general.
     * El orden ya viene del DAO (por nombre del profesor).
     */
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

    // Getters y setters

    public Integer getIdProfesorSeleccionado() {
        return idProfesorSeleccionado;
    }

    public void setIdProfesorSeleccionado(Integer idProfesorSeleccionado) {
        this.idProfesorSeleccionado = idProfesorSeleccionado;
    }

    public Integer getIdUnidadSeleccionada() {
        return idUnidadSeleccionada;
    }

    public void setIdUnidadSeleccionada(Integer idUnidadSeleccionada) {
        this.idUnidadSeleccionada = idUnidadSeleccionada;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public List<unidadesDeAprendizaje> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<unidadesDeAprendizaje> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public List<Asignacion> getListaAsignaciones() {
        return listaAsignaciones;
    }

    public void setListaAsignaciones(List<Asignacion> listaAsignaciones) {
        this.listaAsignaciones = listaAsignaciones;
    }
}
