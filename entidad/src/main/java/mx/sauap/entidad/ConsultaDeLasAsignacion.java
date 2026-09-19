package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Profesor_has_Unidades_De_Aprendizaje", schema = "sauap_proyecto")
@IdClass(ConsultaDeLasAsignacionPK.class)
public class ConsultaDeLasAsignacion implements Serializable {

    @Id
    @Column(name = "id_Clase")
    private Integer idClase;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Profesor_id_Profesor", nullable = false)
    private Profesor profesor;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Unidades_De_Aprendizaje_id_Unidades_De_Aprendizaje", nullable = false)
    private unidadesDeAprendizaje unidadDeAprendizaje;

    public ConsultaDeLasAsignacion() {}

    public Integer getIdClase() {
        return idClase;
    }
    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public unidadesDeAprendizaje getUnidadDeAprendizaje() {
        return unidadDeAprendizaje;
    }
    public void setUnidadDeAprendizaje(unidadesDeAprendizaje unidadDeAprendizaje) {
        this.unidadDeAprendizaje = unidadDeAprendizaje;
    }
}