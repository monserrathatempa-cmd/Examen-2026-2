package mx.Examen2026.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @Column(name = "id_Administrador", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "administradorIdAdministrador")
    private Set<UnidadesDeAprendizaje> unidadesDeAprendizajes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<UnidadesDeAprendizaje> getUnidadesDeAprendizajes() {
        return unidadesDeAprendizajes;
    }

    public void setUnidadesDeAprendizajes(Set<UnidadesDeAprendizaje> unidadesDeAprendizajes) {
        this.unidadesDeAprendizajes = unidadesDeAprendizajes;
    }

}