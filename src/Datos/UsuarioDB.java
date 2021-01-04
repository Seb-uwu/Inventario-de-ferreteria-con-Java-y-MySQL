
package Datos;

import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDB extends Conexion{
    Usuario usuario1 = new Usuario();

    private Connection conn = null;
    Conexion cn = null;
    Statement pst = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    Conexion connn=null;
    Statement st=null;
    DefaultTableModel model;
    
    public boolean login_Usuario(String usuario, String clave) {
        conn = getConexion();
        sql = "select * from usuario where usuario = ? and clave = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenido Usuario "+usuario);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existe, Intentelo nuevamente");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la lectura de la tabla Usuario" + ex.getMessage());
            return false;
        }
    }
    
    public boolean graba_usuario(Usuario usuario) {
        conn = getConexion();
        sql = "insert into usuario values (null, ?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getClave());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getNombres());
            ps.setString(5, usuario.getEstado());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de grabacion de usuario" + ex.getMessage());
            return false;
        }
    }

    public Usuario Busca_Usuario1(String usuario, String clave) {
        conn = getConexion();
        sql = "select * from usuario where usuario = ? and clave = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario1.setApellidos(rs.getString("apellidos"));
                usuario1.setNombres(rs.getString("nombres"));

                return usuario1;
            } else {
                usuario1.setApellidos("nada");
                return usuario1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en la lectura de la tabla usuario" + ex.getMessage());
            usuario1.setApellidos("nada");
            return usuario1;
        }
    }

    public boolean Actualiza_usuario(Usuario usuario) {
        conn = getConexion();
        sql = "update  usuario set clave = ?, apellidos = ?, nombres = ? where usuario = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, usuario.getClave());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getUsuario());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de actualizacion de usuario" + ex.getMessage());
            return false;
        }
    }

    public boolean Borrar_usuario(String usuario) {
        conn = getConexion();
        sql = "delete from usuario where usuario = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de borrado de usuario");
            return false;
        }
    }

    public boolean Valida_Usuario(String usuario) {
        conn = getConexion();
        sql = "select * from usuario where usuario = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de lectura de usuario");
            return false;
        }

    }
        public ResultSet fillUsuario() throws SQLException {
        cn = new Conexion();
        pst = cn.getConexion().createStatement();
        rs = pst.executeQuery("SELECT usuario,clave,apellidos,nombres,estado FROM USUARIO");
        return rs;
    }

    public DefaultTableModel BarraBuscarUsuario(String Texto) {
        try {
            String[] titulos = {"Usuario", "Clave", "Apellidos", "Nombres", "Estado"};
            String filtro=""+Texto+"%";
            String sql = "select * from USUARIO where usuario like"+'"'+filtro+'"';
            model=new DefaultTableModel(null,titulos);
            connn = new Conexion();
            st = connn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[5];
            while (rs.next()) {
                fila[0] = rs.getString("usuario");
                fila[1] = rs.getString("clave");
                fila[2] = rs.getString("apellidos");
                fila[3] = rs.getString("nombres");
                fila[4] = rs.getString("estado");
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }
}
