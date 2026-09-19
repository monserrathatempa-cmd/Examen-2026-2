package mx.sauap.entidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJPAMain {

    public static void main(String[] args) {
        try {
            System.out.println("=== INICIANDO CONEXIÓN A MYSQL Y PRUEBA JPA ===");

            // Forzar las propiedades de conexión por código
            Map<String, String> properties = new HashMap<>();
            properties.put("jakarta.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
            properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
            properties.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/sauap_proyecto?useSSL=false&serverTimezone=UTC");
            properties.put("jakarta.persistence.jdbc.user", "root");
            properties.put("jakarta.persistence.jdbc.password", "TU_CONTRASEÑA_REAL"); // <-- Pon tu contraseña real aquí
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.show_sql", "true");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("sauap_proyecto", properties);
            EntityManager em = emf.createEntityManager();

            System.out.println("-> Conexión establecida con éxito.");

            // Consulta rápida para verificar lectura
            List<unidadesDeAprendizaje> lista = em.createQuery("SELECT u FROM unidadesDeAprendizaje u", unidadesDeAprendizaje.class).getResultList();
            System.out.println("-> Unidades registradas en BD: " + lista.size());

            em.close();
            emf.close();
            System.out.println("=== PRUEBA FINALIZADA CORRECTAMENTE ===");

        } catch (Exception e) {
            System.err.println("❌ ERROR AL EJECUTAR JPA:");
            e.printStackTrace();
        }
    }
}