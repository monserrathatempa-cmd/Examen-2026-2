package java.mx.sauap.persistencia;


import java.util.List;

public class MainPrueba {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   INICIANDO PRUEBA DE CONEXIÓN Y DAO    ");
        System.out.println("=========================================\n");

        // 1. Instanciar el DAO de Profesor
        ProfesorDAO profesorDAO = new ProfesorDAO();

        // 2. Crear una nueva entidad Profesor de prueba
        profesorUA nuevoProfesor = new profesorUA();
        nuevoProfesor.setNombreProfesor("Carlos");
        nuevoProfesor.setApellidoPaterno("Gómez");
        nuevoProfesor.setApellidoMaterno("Pérez");
        nuevoProfesor.setRfc("GOPC850101XYZ"); // RFC válido de prueba

        try {
            // 3. Probar la inserción (Guardar en MySQL)
            System.out.println("[PASO 1] Intentando guardar un nuevo profesor en MySQL...");
            profesorDAO.guardar(nuevoProfesor);
            System.out.println(">> ¡ÉXITO! Profesor guardado con ID asignado: " + nuevoProfesor.getIdProfesor() + "\n");

            // 4. Probar la lectura (Consultar todos los profesores)
            System.out.println("[PASO 2] Consultando la lista de profesores en la BD...");
            List<profesorUA> listaProfesores = profesorDAO.obtenerTodosOrdenados();

            System.out.println("\n--- REGISTROS ENCONTRADOS EN LA TABLA 'Profesor' ---");
            if (listaProfesores.isEmpty()) {
                System.out.println("No hay profesores registrados.");
            } else {
                for (profesorUA p : listaProfesores) {
                    System.out.println("ID: " + p.getIdProfesor() +
                            " | Nombre: " + p.getNombreProfesor() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno() +
                            " | RFC: " + p.getRfc());
                }
            }
            System.out.println("---------------------------------------------------\n");

        } catch (Exception e) {
            System.err.println("\n[ERROR] Ocurrió un fallo durante la prueba:");
            e.printStackTrace();
        } finally {
            // 5. Cerrar el SessionFactory de Hibernate
            System.out.println("[PASO 3] Cerrando fábrica de conexiones de Hibernate...");
            HibernateUtil.shutdown();
            System.out.println("=========================================");
            System.out.println("           PRUEBA FINALIZADA             ");
            System.out.println("=========================================");
        }
    }
}
