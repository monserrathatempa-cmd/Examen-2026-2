package mx.sauap.facade;

import mx.sauap.delegate.ProfesorDelegate;
import mx.sauap.entidad.Profesor;
import java.util.List;

public class ProfesorFacade {

    private final ProfesorDelegate delegate;

    public ProfesorFacade() {
        this.delegate = new ProfesorDelegate();
    }

    public void guardarProfesor(Profesor profesor) throws Exception {
        delegate.guardarProfesor(profesor);
    }

    public List<Profesor> obtenerTodosProfesores() {
        return delegate.obtenerTodosProfesores();
    }
}