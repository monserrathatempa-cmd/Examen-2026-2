package mx.sauap.delegate;

import mx.sauap.entidad.admin;
import mx.sauap.persistencia.AdminDAO;

public class AdminDelegate {

    private final AdminDAO adminDAO;

    public AdminDelegate() {
        this.adminDAO = new AdminDAO();
    }

    public admin autenticar(String usuario, String password) throws Exception {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario es obligatorio.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria.");
        }

        admin encontrado = adminDAO.buscarPorCredenciales(usuario.trim(), password);
        if (encontrado == null) {
            throw new IllegalArgumentException("Usuario o contraseña incorrectos.");
        }
        return encontrado;
    }

    public boolean existeUsuario(String usuario) {
        return adminDAO.existeUsuario(usuario);
    }
}