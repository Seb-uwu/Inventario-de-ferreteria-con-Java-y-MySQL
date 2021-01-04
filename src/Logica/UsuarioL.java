package Logica;

import Entidad.Usuario;
import Datos.UsuarioDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class UsuarioL {

    UsuarioDB objUsuario = new UsuarioDB();

    public boolean login_Usuario(String usuario, String clave) {
        return objUsuario.login_Usuario(usuario, clave);
    }

    public boolean graba_usuario(Usuario usuario) {
        return objUsuario.graba_usuario(usuario);
    }

    public Usuario Busca_Usuario1(String usuario, String clave) {
        return objUsuario.Busca_Usuario1(usuario, clave);
    }

    public boolean Actualiza_usuario(Usuario usuario) {
        return objUsuario.Actualiza_usuario(usuario);
    }

    public boolean Borrar_usuario(String usuario) {
        return objUsuario.Borrar_usuario(usuario);
    }

    public boolean Valida_Usuario(String usuario) {
        return objUsuario.Valida_Usuario(usuario);
    }

    public ResultSet fillUsuario() throws SQLException {
        return objUsuario.fillUsuario();
    }

    public DefaultTableModel BarraBuscarUsuario(String Texto) {
        return objUsuario.BarraBuscarUsuario(Texto);
    }
}
