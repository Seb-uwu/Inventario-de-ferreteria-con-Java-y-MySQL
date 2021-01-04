package Datos;

import Entidad.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaDB extends Conexion {

    Categoria objCategoria = new Categoria();
    private Connection conn = null;
    Conexion cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    Statement pst = null;
    Conexion connn=null;
    Statement st=null;
    DefaultTableModel model;

    public boolean Graba_Categoria(Categoria categoria) {
        conn = getConexion();
        sql = "Insert into CATEGORIA values(null,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de grabación de la TBCategoria" + ex);
            return false;
        }
    }

    public Categoria Busca_Categoria(String Cod_Categoria) {
        conn = getConexion();
        sql = "select * from CATEGORIA where Cod_Categoria=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Cod_Categoria);
            rs = ps.executeQuery();
            if (rs.next()) {
                objCategoria.setCod_Categoria(rs.getInt("Cod_Categoria"));
                objCategoria.setCategoria(rs.getString("Categoria"));

                return objCategoria;
            } else {
//                JOptionPane.showMessageDialog(null, "No existe el codigo");
                objCategoria.setCategoria("Nada");
                return objCategoria;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de seleccionar de la TBCategoria" + ex);
            objCategoria.setCategoria("Nada");
            return objCategoria;
        }
    }

    public boolean Actualiza_Categoria(Categoria categoria) {
        conn = getConexion();
        sql = "update CATEGORIA set Categoria=? where Cod_Categoria=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(2, categoria.getCod_Categoria());
            ps.setString(1, categoria.getCategoria());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de la TBCategoria" + ex);
            return false;
        }
    }

    public boolean Eliminar_Categoria(String Cod_Categoria) {
        conn = getConexion();
        sql = "delete from CATEGORIA where Cod_Categoria=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Cod_Categoria);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese codigo");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    public ResultSet fillCategoria() throws SQLException{
        cn = new Conexion();
        pst=cn.getConexion().createStatement();
        rs=pst.executeQuery("SELECT * FROM CATEGORIA");
        return rs;
    }
    public DefaultTableModel BarraBuscarCategoria(String Texto) {
        try {
            String[] titulos = {"Cod.Cat","Categoria"};
            String filtro=""+Texto+"%";
            String sql = "select * from CATEGORIA where Cod_Categoria like"+'"'+filtro+'"';
            model=new DefaultTableModel(null,titulos);
            connn = new Conexion();
            st = connn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[2];
            while (rs.next()) {
                fila[0] = rs.getString("Cod_Categoria");
                fila[1] = rs.getString("Categoria");
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }
    public void Combo_box(JComboBox box_categoria) {

        sql = "SELECT Categoria FROM CATEGORIA";

        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            box_categoria.addItem("Seleccione una opcion");
            while (rs.next()) {
                box_categoria.addItem(rs.getString("Categoria"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,ex);
                }
            }
        }

    }
}
