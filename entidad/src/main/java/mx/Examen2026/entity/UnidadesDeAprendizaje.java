package mx.Examen2026.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "unidades_de_aprendizaje")
public class UnidadesDeAprendizaje {
    @EmbeddedId
    private UnidadesDeAprendizajeId id;

    @MapsId("administradorIdAdministrador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Administrador_id_Administrador", nullable = false)
    private Administrador administradorIdAdministrador;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre_Unidades_De_Aprendizaje", nullable = false, length = 50)
    private String nombreUnidadesDeAprendizaje;

    @NotNull
    @Column(name = "horas_Clase", nullable = false)
    private Integer horasClase;

    @NotNull
    @Column(name = "horas_Taller", nullable = false)
    private Integer horasTaller;

    @NotNull
    @Column(name = "horas_Laboratorio", nullable = false)
    private Integer horasLaboratorio;

    public UnidadesDeAprendizajeId getId() {
        return id;
    }

    public void setId(UnidadesDeAprendizajeId id) {
        this.id = id;
    }

    public Administrador getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(Administrador administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    public String getNombreUnidadesDeAprendizaje() {
        return nombreUnidadesDeAprendizaje;
    }

    public void setNombreUnidadesDeAprendizaje(String nombreUnidadesDeAprendizaje) {
        this.nombreUnidadesDeAprendizaje = nombreUnidadesDeAprendizaje;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

}