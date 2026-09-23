package mx.sauap.main;

import mx.sauap.integration.ServiceFacadeLocator;
import mx.sauap.entidad.Profesor;
import mx.sauap.entidad.unidadesDeAprendizaje;
import mx.sauap.entidad.Asignacion;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   INICIANDO PRUEBAS DE LA CAPA DE NEGOCIO       ");
        System.out.println("=================================================\n");

        try {
            // -----------------------------------------------------------------
            // 1. PRUEBA DE PROFESOR FACADE
            // -----------------------------------------------------------------
            System.out.println("---> 1. Probando ProfesorFacade...");
            Profesor nuevoProfesor = new Profesor();
            nuevoProfesor.setNombreProfesor("Juan");
            nuevoProfesor.setApellidoPaterno("Pérez");
            nuevoProfesor.setApellidoMaterno("López");
            nuevoProfesor.setRfc("PELJ850101XXX");

            ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(nuevoProfesor);
            System.out.println("✔ Profesor guardado exitosamente: "
                    + nuevoProfesor.getNombreProfesor() + " " + nuevoProfesor.getApellidoPaterno());

            List<Profesor> listaProfesores = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerTodosProfesores();
            System.out.println("✔ Total de profesores en sistema: " + listaProfesores.size());
            for (Profesor p : listaProfesores) {
                System.out.println("   - ID: " + p.getIdProfesor() + " | Nombre: "
                        + p.getNombreProfesor() + " " + p.getApellidoPaterno() + " | RFC: " + p.getRfc());
            }

            System.out.println("\n-------------------------------------------------");

            // -----------------------------------------------------------------
            // 2. PRUEBA DE UNIDADES DE APRENDIZAJE FACADE
            // -----------------------------------------------------------------
            System.out.println("---> 2. Probando UnidadesDeAprendizajeFacade...");
            unidadesDeAprendizaje nuevaUnidad = new unidadesDeAprendizaje();
            nuevaUnidad.setNombreUDA("Programación Orientada a Objetos");
            nuevaUnidad.setHoraC(3);
            nuevaUnidad.setHoraT(2);
            nuevaUnidad.setHoraL(1);

            ServiceFacadeLocator.getInstanceFacadeUnidadesDeAprendizaje().guardarUnidad(nuevaUnidad);
            System.out.println("✔ Unidad guardada exitosamente: " + nuevaUnidad.getNombreUDA());

            List<unidadesDeAprendizaje> listaUnidades = ServiceFacadeLocator.getInstanceFacadeUnidadesDeAprendizaje().obtenerTodasUnidades();
            System.out.println("✔ Total de unidades de aprendizaje: " + listaUnidades.size());
            for (unidadesDeAprendizaje u : listaUnidades) {
                System.out.println("   - ID: " + u.getIdUnidadDeAprendizaje() + " | Materia: "
                        + u.getNombreUDA() + " | C:" + u.getHoraC() + " T:" + u.getHoraT() + " L:" + u.getHoraL());
            }

            System.out.println("\n-------------------------------------------------");

            // -----------------------------------------------------------------
            // 3. PRUEBA DE ASIGNACION FACADE
            // -----------------------------------------------------------------
            System.out.println("---> 3. Probando AsignacionFacade...");
            if (!listaProfesores.isEmpty() && !listaUnidades.isEmpty()) {
                Profesor profAsignado = listaProfesores.get(0);
                unidadesDeAprendizaje unidadAsignada = listaUnidades.get(0);

                Asignacion asignacion = new Asignacion();
                asignacion.setProfesor(profAsignado);
                asignacion.setUnidadDeAprendizaje(unidadAsignada);
                asignacion.setPeriodo("2026-1");

                ServiceFacadeLocator.getInstanceFacadeAsignacion().guardarAsignacion(asignacion);
                System.out.println("✔ Asignación registrada exitosamente.");

                List<Asignacion> listaAsignaciones = ServiceFacadeLocator.getInstanceFacadeAsignacion().obtenerTodasAsignaciones();
                System.out.println("✔ Total de asignaciones: " + listaAsignaciones.size());
                for (Asignacion a : listaAsignaciones) {
                    System.out.println("   - ID: " + a.getIdAsignacion()
                            + " | Profesor: " + a.getProfesor().getNombreProfesor()
                            + " | UDA: " + a.getUnidadDeAprendizaje().getNombreUDA()
                            + " | Periodo: " + a.getPeriodo());
                }
            } else {
                System.out.println("⚠ No hay suficientes datos de profesores o unidades para realizar la prueba de asignación.");
            }

            System.out.println("\n=================================================");
            System.out.println("   TODAS LAS PRUEBAS FINALIZARON CON ÉXITO       ");
            System.out.println("=================================================");

        } catch (Exception e) {
            System.err.println("\n ERROR EN LAS PRUEBAS DE NEGOCIO:");
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}