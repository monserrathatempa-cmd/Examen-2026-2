package mx.sauap.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Unidades_De_Aprendizaje", schema = "sauap_proyecto")
public class unidadesDeAprendizaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Unidades_De_Aprendizaje")
    private Integer idUnidadDeAprendizaje;

    @Column(name = "nombre_Unidades_De_Aprendizaje", length = 50, nullable = false)
    private String nombreUDA;

    @Min(value = 0, message = "No introducir números negativos")
    @Max(value = 4, message = "Máximo de horas 4")
    @Column(name = "horas_Clase", nullable = false)
    private Integer horaC;

    @Min(value = 0, message = "No introducir números negativos")
    @Max(value = 4, message = "Máximo de horas 4")
    @Column(name = "horas_Taller", nullable = false)
    private Integer horaT;

    @Min(value = 0, message = "No introducir números negativos")
    @Max(value = 4, message = "Máximo de horas 4")
    @Column(name = "horas_Laboratorio", nullable = false)
    private Integer horaL;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "Administrador_id_Administrador",
            referencedColumnName = "id_Administrador",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private admin administrador;

    @OneToMany(mappedBy = "unidadDeAprendizaje", fetch = FetchType.LAZY)
    private List<ConsultaDeLasAsignacion> asignaciones;

    public unidadesDeAprendizaje() {}

    public Integer getIdUnidadDeAprendizaje() {
        return idUnidadDeAprendizaje;
    }

    public void setIdUnidadDeAprendizaje(Integer idUnidadDeAprendizaje) {
        this.idUnidadDeAprendizaje = idUnidadDeAprendizaje;
    }

    public String getNombreUDA() {
        return nombreUDA;
    }

    public void setNombreUDA(String nombreUDA) {
        this.nombreUDA = nombreUDA;
    }

    public Integer getHoraC() {
        return horaC;
    }

    public void setHoraC(Integer horaC) {
        this.horaC = horaC;
    }

    public Integer getHoraT() {
        return horaT;
    }

    public void setHoraT(Integer horaT) {
        this.horaT = horaT;
    }

    public Integer getHoraL() {
        return horaL;
    }

    public void setHoraL(Integer horaL) {
        this.horaL = horaL;
    }

    public admin getAdministrador() {
        return administrador;
    }

    public void setAdministrador(admin administrador) {
        this.administrador = administrador;
    }

    public List<ConsultaDeLasAsignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<ConsultaDeLasAsignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}