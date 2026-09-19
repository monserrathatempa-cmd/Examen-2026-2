package mx.sauap.entidad;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "administrador", schema = "sauap_proyecto")
public class admin implements Serializable {
    @Id
    @Column(name = "id_Administrador")
    private Integer idAdministrador;


    public admin() {}

    public Integer getIdAdmin() {
        return idAdministrador;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdministrador = idAdmin;
    }
}