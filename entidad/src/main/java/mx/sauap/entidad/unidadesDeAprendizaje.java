package mx.sauap.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "Unidades_De_Aprendizaje", schema ="sauap_proyecto")


public class unidadesDeAprendizaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="nombre_Unidades_De_Aprendizaje")
    private Iteger idUnidadDeAprendizaje;

    @Column (name="nombre_Unidades_De_Aprendizaje", lenght = 50, nullable =false)
    private String nombreUDA; //UAD: UNIDAD DE APRENDIZAJE
    @Min(value = 0, messege = "no introducir numeros nengativos")
    @Max(value = 4, messege = "Maximo de horas 4")
    @Column (name="hora_De_Clase", nullable = false) //hora de clase
    private Iteger horaC;

    @Min(value = 0, messege = "no introducir numeros nengativos")
    @Max(value = 4, messege = "Maximo de horas 4")
    @Column (name="hora_De_Taller", nullable = false) //horas de taller
    private Iteger horaT;

    @Min(value = 0, messege = "no introducir numeros nengativos")
    @Max(value = 4, messege = "Maximo de horas 4")
    @Column (name="horas_De_Laboratorio", nullable = false)//horas de laboratorio
    private Iteger horaL;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="Administrador_id_Adminstrador" nullable = false)
    private admin administrador;
    @OneToMany(mappedBy = "UnidadDeApredizaje", fetch = FetchType.LAZY)
    private List<ConsultaDeLasAsignacion> asignaciones;

    public UnidadesDeApredizaje(){}

    public Iteger getIdUnidadDeAprendizaje() {
        return idUnidadDeAprendizaje;
    }
    public void setIdUnidadDeAprendizaje(Iteger idUnidadDeAprendizaje) {
        this.idUnidadDeAprendizaje = idUnidadDeAprendizaje;
    }
 //
    public String getNombreUDA() {
        return nombreUDA;
    }
    public void setNombreUDA(String nombreUDA) {
        this.nombreUDA = nombreUDA;
    }
 //
    public Iteger getHoraC() {
        return horaC;
    }
    public void setHoraC(Iteger horaC) {
        this.horaC = horaC;
    }
 //
    public Iteger getHoraL() {
        return horaL;
    }
    public void setHoraL(Iteger horaL) {
        this.horaL = horaL;
    }
 //
    public Iteger getHoraT() {
        return horaT;
    }
    public void setHoraT(Iteger horaT) {
        this.horaT = horaT;
    }
 //
    public admin getAdministrador() {
        return administrador;
    }
    public void setAdministrador(admin administrador) {
        this.administrador = administrador;
    }
 //
    public List<ConsultaDeLasAsignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<ConsultaDeLasAsignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
