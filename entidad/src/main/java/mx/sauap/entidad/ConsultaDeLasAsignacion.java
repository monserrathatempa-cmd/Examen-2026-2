package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesor_has_unidades_de_aprendizaje", schema = "sauap_proyecto")
@IdClass(ConsultaDeLasAsignacionPK.class)
public class ConsultaDeLasAsignacion implements Serializable {

    @Id
    @Column(name = "id_clase")
    private Integer idClase;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "profesor_id_profesor",
            referencedColumnName = "id_profesor",
            nullable = false
    )
    private Profesor profesor;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "unidades_de_aprendizaje_id_unidades_de_aprendizaje",
            referencedColumnName = "id_unidades_de_aprendizaje",
            nullable = false
    )
    private unidadesDeAprendizaje unidadDeAprendizaje;

    public ConsultaDeLasAsignacion() {}

    public Integer getIdClase() { return idClase; }
    public void setIdClase(Integer idClase) { this.idClase = idClase; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    public unidadesDeAprendizaje getUnidadDeAprendizaje() { return unidadDeAprendizaje; }
    public void setUnidadDeAprendizaje(unidadesDeAprendizaje unidadDeAprendizaje) { this.unidadDeAprendizaje = unidadDeAprendizaje; }
}