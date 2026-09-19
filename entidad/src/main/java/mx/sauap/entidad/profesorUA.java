package mx.sauap.entidad;
//Consulta de la unidad de aprendizaje PK
import java.io.Serializable;
import java.util.Objects;


public class profesorUA implements Serializable {

    private Integer profesor;
    private Integer unidadDeAprendizaje;
    private Integer idClase;

    public profesorUA(){}

    public Integer getIdClase() {
        return idClase;
    }
    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }
//
    public Integer getProfesor() {
        return profesor;
    }
    public void setProfesor(Integer profesor) {
        this.profesor = profesor;
    }
//
    public Integer getUnidadDeAprendizaje() {
        return unidadDeAprendizaje;
    }
    public void setUnidadDeAprendizaje(Integer unidadDeAprendizaje) {
        this.unidadDeAprendizaje = unidadDeAprendizaje;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if (o==null || getIdClase() !=o.getClase))
        return false;
     profesorUA that = (profesorUA) o;
     return objects.equals(profesor, that.profesor) &&
             objects.equals(unidadDeAprendizaje, that.unidadDeAprendizaje) &&
             objects.equals(idClase, that.idClase)
    }
    @Override
    public int hashCode() {
        return Objects.hash(profesor,idClase,profesorUA)
    }
}
