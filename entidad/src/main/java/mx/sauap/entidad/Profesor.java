package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.list;

/*esta es la clase de entidad de Profesor,
aqui especifique los parametros*/

@Entity
@Table(name= "Profesor", schema = "sauap_proyecto")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_Profesor")
    private Integer idProfesor;

    @Column(name= "nombre_Profesor", length=50, nullable = false)
    private String nombreProfesor;

    @Column(name= "apellido_paterno", length=50, nullable = false)
    private String nombreProfesor;

}
