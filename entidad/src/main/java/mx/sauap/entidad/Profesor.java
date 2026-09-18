package mx.sauap.entidad;

import jakarta.persistence.*;
import .validation.constraints.Pattern;
import java.io.Serializable;
import java.util.list;

/*esta es la clase de entidad de Profesor,
aqui especifique los parametros*/

@Entity
@Table(name= "Profesor", schema = "sauap_proyecto")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_Profesor")
    private Integer idProfesor;

    @Column(name= "nombre_Profesor", length=50, nullable = false)
    private String nombreProfesor;

    @Column(name= "apellido_paterno", length=50, nullable = false)
    private String apellidoP;

    @Column(name= "apellido_materno", length=50, nullable = false)
    private String apellidoM;

    @Pattern(regexp = "^[A-Z&Ñ]{3,4}[0-9]{6}[A-V1-9][A-Z1-9][0-9A]$", message = "El formato de RFC no es valido, Intente De Nuevo")
    @Column(name= "rfc", length=50, nullable = false)
    private String rfc;

    @OneToMany(mappedBy = "profesor", FetchType.LAZY)
    private List<ConsultaDeLasAsignacion> asignaciones;

    public Profesor(){}

    public Integer getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
//
    public String getNombreProfesor() {
        return nombreProfesor;
    }
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
 //
    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
 //
    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
 //
    public List<ConsultaDeLasAsignacion> getAsignaciones() {
        return asignaciones;
    }
    public void setAsignaciones(List<ConsultaDeLasAsignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
 //
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
