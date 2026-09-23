package mx.sauap.ui;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import mx.sauap.entidad.admin;
import mx.sauap.helper.AdminHelper;

import java.io.Serializable;

@Named("adminBeanUI")
@SessionScoped
public class AdminBeanUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private String usuario;
    private String password;

    private final AdminHelper helper = new AdminHelper();

    public AdminBeanUI() {
    }


    public String login() {
        try {
            admin adminLogueado = helper.autenticar(usuario, password);
            helper.guardarEnSesion(adminLogueado);
            helper.mensajeInfo("Bienvenido", "Hola, " + adminLogueado.getUsuario());
            limpiar();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            helper.mensajeError("Error de autenticación", e.getMessage());
            return null;
        }
    }

    public String logout() {
        helper.cerrarSesion();
        limpiar();
        return "login?faces-redirect=true";
    }

    public boolean isLogueado() {
        return helper.obtenerAdminLogueado() != null;
    }

    public String getNombreAdminLogueado() {
        admin a = helper.obtenerAdminLogueado();
        return a != null ? a.getUsuario() : "";
    }

    private void limpiar() {
        this.usuario = null;
        this.password = null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}