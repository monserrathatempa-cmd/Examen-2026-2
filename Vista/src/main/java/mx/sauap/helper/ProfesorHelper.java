package mx.sauap.helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.sauap.entidad.Profesor;
import mx.sauap.facade.ProfesorFacade;
import mx.sauap.integration.ServiceFacadeLocator;

import java.util.List;
import java.util.regex.Pattern;


public class ProfesorHelper {

    // RFC mexicano: 3 o 4 letras + 6 dígitos + 3 caracteres alfanuméricos
    private static final Pattern RFC_PATTERN =
            Pattern.compile("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$");

    private final ProfesorFacade facade;

    public ProfesorHelper() {
        this.facade = ServiceFacadeLocator.getInstanceFacadeProfesor();
    }

    public boolean esRfcValido(String rfc) {
        return rfc != null && RFC_PATTERN.matcher(rfc).matches();
    }

    public void guardar(Profesor profesor) throws Exception {
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo.");
        }
        if (!esRfcValido(profesor.getRfc())) {
            throw new IllegalArgumentException(
                    "El RFC no tiene el formato correcto (ej. PELJ850101XXX).");
        }
        facade.guardarProfesor(profesor);
    }


    public List<Profesor> obtenerTodos() {
        return facade.obtenerTodosProfesores();
    }

    public void mensajeError(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle));
    }

    public void mensajeInfo(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }
}
