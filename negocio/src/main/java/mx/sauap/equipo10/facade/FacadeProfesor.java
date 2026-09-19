package mx.sauap.equipo10.facade;

import mx.sauap.equipo10.delegate.DelegateProfesor;
import mx.sauap.entidad.Profesor;
import java.util.List;

public class FacadeProfesor {

    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor) throws Exception {
        delegateProfesor.guardarProfesor(profesor);
    }

    public void actualizarProfesor(Profesor profesor) throws Exception {
        delegateProfesor.actualizarProfesor(profesor);
    }

    public void eliminarProfesor(Profesor profesor) throws Exception {
        delegateProfesor.eliminarProfesor(profesor);
    }

    public List<Profesor> obtenerTodosProfesores() {
        return delegateProfesor.obtenerTodosProfesores();
    }

    public Profesor buscarProfesorPorId(Integer id) {
        return delegateProfesor.buscarProfesorPorId(id);
    }
}