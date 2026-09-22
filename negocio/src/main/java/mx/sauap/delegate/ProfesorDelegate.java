package mx.sauap.delegate;

import mx.sauap.entidad.Profesor;
import mx.sauap.persistencia.ProfesorDAO;
import java.util.List;

public class ProfesorDelegate {

    private final ProfesorDAO profesorDAO;

    public ProfesorDelegate() {
        this.profesorDAO = new ProfesorDAO();
    }

    public void guardarProfesor(Profesor profesor) throws Exception {
        if (profesor.getNombreProfesor() == null || profesor.getNombreProfesor().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del profesor es obligatorio.");
        }
        if (profesor.getApellidoPaterno() == null || profesor.getApellidoPaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno es obligatorio.");
        }
        if (profesor.getRfc() == null || profesor.getRfc().trim().isEmpty()) {
            throw new IllegalArgumentException("El RFC es obligatorio.");
        }
        profesorDAO.guardar(profesor);
    }

    public List<Profesor> obtenerTodosProfesores() {
        return profesorDAO.obtenerTodosOrdenados();
    }
}