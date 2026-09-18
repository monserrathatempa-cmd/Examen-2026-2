package mx.sauap.entidad;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "Unidades_De_Aprendizaje", schema ="sauap_proyecto")


public class unidadesDeAprendizaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column (name="nombre_Unidades_De_Aprendizaje")
    private Iteger idUnidadDeAprendizaje;


}
