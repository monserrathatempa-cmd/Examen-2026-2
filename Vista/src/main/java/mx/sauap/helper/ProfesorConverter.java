package mx.sauap.helper;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mx.sauap.entidad.Profesor;
import mx.sauap.facade.ProfesorFacade;
import mx.sauap.integration.ServiceFacadeLocator;

import java.util.List;

@FacesConverter("profesorConverter")
public class ProfesorConverter implements Converter<Profesor> {

    @Override
    public Profesor getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.valueOf(value);
            ProfesorFacade facade = ServiceFacadeLocator.getInstanceFacadeProfesor();
            List<Profesor> lista = facade.obtenerTodosProfesores();
            for (Profesor p : lista) {
                if (p.getIdProfesor().equals(id)) {
                    return p;
                }
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Profesor value) {
        if (value == null || value.getIdProfesor() == null) {
            return "";
        }
        return String.valueOf(value.getIdProfesor());
    }
}
