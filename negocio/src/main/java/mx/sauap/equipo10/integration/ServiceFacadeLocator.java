package mx.sauap.equipo10.integration;

import mx.sauap.equipo10.facade.FacadeProfesor;
import mx.sauap.equipo10.facade.FacadeUnidadesDeAprendizaje;
import mx.sauap.equipo10.facade.FacadeAsignacion;

public class ServiceFacadeLocator {

    private static FacadeProfesor facadeProfesor;
    private static FacadeUnidadesDeAprendizaje facadeUnidadesDeAprendizaje;
    private static FacadeAsignacion facadeAsignacion;

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
        }
        return facadeProfesor;
    }

    public static FacadeUnidadesDeAprendizaje getInstanceFacadeUnidadesDeAprendizaje() {
        if (facadeUnidadesDeAprendizaje == null) {
            facadeUnidadesDeAprendizaje = new FacadeUnidadesDeAprendizaje();
        }
        return facadeUnidadesDeAprendizaje;
    }

    public static FacadeAsignacion getInstanceFacadeAsignacion() {
        if (facadeAsignacion == null) {
            facadeAsignacion = new FacadeAsignacion();
        }
        return facadeAsignacion;
    }
}