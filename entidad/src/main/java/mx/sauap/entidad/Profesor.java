package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesor", schema = "sauap_proyecto")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "nombre_profesor", length = 50, nullable = false)
    private String nombreProfesor;

    @Column(name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "rfc", length = 15, nullable = false)
    private String rfc;

    public Profesor() {}

    public Integer getIdProfesor() { return idProfesor; }
    public void setIdProfesor(Integer idProfesor) { this.idProfesor = idProfesor; }

    public String getNombreProfesor() { return nombreProfesor; }
    public void setNombreProfesor(String nombreProfesor) { this.nombreProfesor = nombreProfesor; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
}