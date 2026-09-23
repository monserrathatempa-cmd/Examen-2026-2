package mx.sauap.helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import mx.sauap.delegate.AdminDelegate;
import mx.sauap.entidad.admin;

public class AdminHelper {

    private final AdminDelegate adminDelegate;

    public AdminHelper() {
        this.adminDelegate = new AdminDelegate();
    }

    public admin autenticar(String usuario, String password) throws Exception {
        return adminDelegate.autenticar(usuario, password);
    }

    public void guardarEnSesion(admin adminLogueado) {
        HttpSession session = obtenerSesion(true);
        session.setAttribute("adminLogueado", adminLogueado);
    }

    public admin obtenerAdminLogueado() {
        HttpSession session = obtenerSesion(false);
        if (session == null) return null;
        return (admin) session.getAttribute("adminLogueado");
    }


    public void cerrarSesion() {
        HttpSession session = obtenerSesion(false);
        if (session != null) {
            session.invalidate();
        }
    }


    private HttpSession obtenerSesion(boolean crear) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx == null) return null;
        Object sesion = ctx.getExternalContext().getSession(crear);
        return (HttpSession) sesion;
    }


    public void mensajeError(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle));
    }


    public void mensajeInfo(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }
}