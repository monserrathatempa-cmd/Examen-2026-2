package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asignacion", schema = "sauap_proyecto")
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Asignacion")
    private Integer idAsignacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Profesor_id_Profesor", nullable = false)
    private Profesor profesor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Unidades_De_Aprendizaje_id_Unidad", nullable = false)
    private unidadesDeAprendizaje unidadDeAprendizaje;

    @Column(name = "periodo", length = 20, nullable = false)
    private String periodo;

    public Asignacion() {}

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}