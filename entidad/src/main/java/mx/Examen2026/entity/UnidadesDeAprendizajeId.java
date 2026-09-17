package mx.Examen2026.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UnidadesDeAprendizajeId implements Serializable {
    private static final long serialVersionUID = -3431310065773305730L;
    @NotNull
    @Column(name = "id_Unidades_De_Aprendizaje", nullable = false)
    private Integer idUnidadesDeAprendizaje;

    @NotNull
    @Column(name = "Administrador_id_Administrador", nullable = false)
    private Integer administradorIdAdministrador;

    public Integer getIdUnidadesDeAprendizaje() {
        return idUnidadesDeAprendizaje;
    }

    public void setIdUnidadesDeAprendizaje(Integer idUnidadesDeAprendizaje) {
        this.idUnidadesDeAprendizaje = idUnidadesDeAprendizaje;
    }

    public Integer getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(Integer administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UnidadesDeAprendizajeId entity = (UnidadesDeAprendizajeId) o;
        return Objects.equals(this.administradorIdAdministrador, entity.administradorIdAdministrador) &&
                Objects.equals(this.idUnidadesDeAprendizaje, entity.idUnidadesDeAprendizaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(administradorIdAdministrador, idUnidadesDeAprendizaje);
    }

}