package mx.sauap.entidad;

import java.io.Serializable;
import java.util.Objects;

public class ConsultaDeLasAsignacionPK implements Serializable {

    private Integer profesor;
    private Integer unidadDeAprendizaje;
    private Integer idClase;

    public ConsultaDeLasAsignacionPK() {}

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Integer getProfesor() {
        return profesor;
    }

    public void setProfesor(Integer profesor) {
        this.profesor = profesor;
    }

    public Integer getUnidadDeAprendizaje() {
        return unidadDeAprendizaje;
    }

    public void setUnidadDeAprendizaje(Integer unidadDeAprendizaje) {
        this.unidadDeAprendizaje = unidadDeAprendizaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaDeLasAsignacionPK that = (ConsultaDeLasAsignacionPK) o;
        return Objects.equals(profesor, that.profesor) &&
                Objects.equals(unidadDeAprendizaje, that.unidadDeAprendizaje) &&
                Objects.equals(idClase, that.idClase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesor, unidadDeAprendizaje, idClase);
    }
}
