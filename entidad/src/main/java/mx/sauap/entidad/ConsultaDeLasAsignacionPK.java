package mx.sauap.entidad;

import java.io.Serializable;
import java.util.Objects;

public class ConsultaDeLasAsignacionPK implements Serializable {

    private Integer idClase;
    private Integer profesor;
    private Integer unidadDeAprendizaje;
    public ConsultaDeLasAsignacionPK() {}

    public ConsultaDeLasAsignacionPK(Integer idClase, Integer profesor, Integer unidadDeAprendizaje) {
        this.idClase = idClase;
        this.profesor = profesor;
        this.unidadDeAprendizaje = unidadDeAprendizaje;
    }

    public Integer getIdClase() { return idClase; }
    public void setIdClase(Integer idClase) { this.idClase = idClase; }

    public Integer getProfesor() { return profesor; }
    public void setProfesor(Integer profesor) { this.profesor = profesor; }

    public Integer getUnidadDeAprendizaje() { return unidadDeAprendizaje; }
    public void setUnidadDeAprendizaje(Integer unidadDeAprendizaje) { this.unidadDeAprendizaje = unidadDeAprendizaje; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaDeLasAsignacionPK that = (ConsultaDeLasAsignacionPK) o;
        return Objects.equals(idClase, that.idClase) &&
                Objects.equals(profesor, that.profesor) &&
                Objects.equals(unidadDeAprendizaje, that.unidadDeAprendizaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClase, profesor, unidadDeAprendizaje);
    }
}