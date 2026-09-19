package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="administrador", schema = "SUAP_PROYECTO")
public class admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_administrador")
    private Interge idAdmin;
    public admin(){}

    public Interge getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Interge idAdmin) {
        this.idAdmin = idAdmin;
    }
}
