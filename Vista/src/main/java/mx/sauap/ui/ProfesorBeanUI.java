package mx.sauap.ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.sauap.entidad.Profesor;
import mx.sauap.helper.ProfesorHelper;

import java.io.Serializable;
import java.util.List;


@Named("profesorBeanUI")
@ViewScoped
public class ProfesorBeanUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private Profesor profesor;
    private List<Profesor> listaProfesores;

    private final ProfesorHelper helper = new ProfesorHelper();

    public ProfesorBeanUI() {
    }

    @PostConstruct
    public void init() {
        profesor = new Profesor();
        cargarLista();
    }


    public void cargarLista() {
        try {
            listaProfesores = helper.obtenerTodos();
        } catch (Exception e) {
            helper.mensajeError("Error al listar", e.getMessage());
        }
    }

    public void guardar() {
        try {
            helper.guardar(profesor);
            helper.mensajeInfo("Éxito", "Profesor registrado correctamente.");
            profesor = new Profesor();
            cargarLista();
        } catch (Exception e) {
            helper.mensajeError("Error al guardar", e.getMessage());
        }
    }

    public void limpiar() {
        profesor = new Profesor();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}