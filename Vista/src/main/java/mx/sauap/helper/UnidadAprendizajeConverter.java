package mx.sauap.helper;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.facade.UnidadesDeAprendizajeFacade;
import mx.sauap.integration.ServiceFacadeLocator;

import java.util.List;

@FacesConverter("unidadConverter")
public class UnidadAprendizajeConverter implements Converter<unidadesDeAprendizaje> {

    @Override
    public unidadesDeAprendizaje getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.valueOf(value);
            UnidadesDeAprendizajeFacade facade =
                    ServiceFacadeLocator.getInstanceFacadeUnidadesDeAprendizaje();
            List<unidadesDeAprendizaje> lista = facade.obtenerTodasUnidades();
            for (unidadesDeAprendizaje u : lista) {
                if (u.getIdUnidadDeAprendizaje().equals(id)) {
                    return u;
                }
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, unidadesDeAprendizaje value) {
        if (value == null || value.getIdUnidadDeAprendizaje() == null) {
            return "";
        }
        return String.valueOf(value.getIdUnidadDeAprendizaje());
    }
}
