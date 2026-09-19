package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Administrador", schema = "sauap_proyecto")
public class admin implements Serializable {

    @Id
    @Column(name = "id_Administrador")
    private Integer idAdmin;

    public admin() {}

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
}