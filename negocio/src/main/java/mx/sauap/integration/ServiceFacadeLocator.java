package mx.sauap.integration;

import mx.sauap.facade.AsignacionFacade;
import mx.sauap.facade.ProfesorFacade;
import mx.sauap.facade.UnidadesDeAprendizajeFacade;

public class ServiceFacadeLocator {

    private static ProfesorFacade instanceProfesor;
    private static UnidadesDeAprendizajeFacade instanceUnidades;
    private static AsignacionFacade instanceAsignacion;

    public static ProfesorFacade getInstanceFacadeProfesor() {
        if (instanceProfesor == null) {
            instanceProfesor = new ProfesorFacade();
        }
        return instanceProfesor;
    }

    public static UnidadesDeAprendizajeFacade getInstanceFacadeUnidadesDeAprendizaje() {
        if (instanceUnidades == null) {
            instanceUnidades = new UnidadesDeAprendizajeFacade();
        }
        return instanceUnidades;
    }

    public static AsignacionFacade getInstanceFacadeAsignacion() {
        if (instanceAsignacion == null) {
            instanceAsignacion = new AsignacionFacade();
        }
        return instanceAsignacion;
    }
}