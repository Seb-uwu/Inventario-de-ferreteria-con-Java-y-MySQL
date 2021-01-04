package Datos;

import Entidad.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Presentacion.Proveedores;
import com.sun.corba.se.impl.activation.ServerMain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ProveedorDB extends Conexion {

    Proveedor objProveedor = new Proveedor();

    private Connection conn = null;
    Conexion cn = null;
    Statement pst = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    Conexion connn=null;
    Statement st=null;
    DefaultTableModel model;

    public boolean Graba_Proveedor(Proveedor proveedor) {
        conn = getConexion();
        sql = "Insert into PROVEEDOR values(null,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, proveedor.getRuc_Provee());
            ps.setString(2, proveedor.getTelefono());
            ps.setString(3, proveedor.getRazon_Social());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getCorreo());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de grabación de la TBProveedor" + ex);
            return false;
        }
    }

    public Proveedor Busca_Proveedor(String RucProvee) {
        conn = getConexion();
        sql = "select * from PROVEEDOR where Ruc_Provee=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, RucProvee);
            rs = ps.executeQuery();
            if (rs.next()) {
                objProveedor.setRuc_Provee(rs.getString("Ruc_Provee"));
                objProveedor.setTelefono(rs.getString("Telefono"));
                objProveedor.setRazon_Social(rs.getString("Razon_Social"));
                objProveedor.setDireccion(rs.getString("Direccion"));
                objProveedor.setCorreo(rs.getString("Correo"));

                return objProveedor;
            } else {
                objProveedor.setRazon_Social("Nada");
                return objProveedor;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de seleccionar de la TBProveedor" + ex);
            objProveedor.setRazon_Social("Nada");
            return objProveedor;
        }
    }

    public boolean Actualiza_Proveedor(Proveedor proveedor) {
        conn = getConexion();
        sql = "update PROVEEDOR set Telefono=?,Razon_Social=?,Direccion=?,Correo=? where Ruc_Provee=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(5, proveedor.getRuc_Provee());
            ps.setString(1, proveedor.getTelefono());
            ps.setString(2, proveedor.getRazon_Social());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getCorreo());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de la TBProveedor" + ex);
            return false;
        }
    }

    public boolean Eliminar_Proveedor(String Ruc_Provee) {
        conn = getConexion();
        sql = "delete from PROVEEDOR where Ruc_Provee=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Ruc_Provee);
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

    public ResultSet fillProveedor() throws SQLException {
        cn = new Conexion();
        pst = cn.getConexion().createStatement();
        rs = pst.executeQuery("SELECT Ruc_Provee,Telefono,Razon_Social,Direccion,Correo FROM PROVEEDOR");
        return rs;
    }

    public DefaultTableModel BarraBuscarProveedor(String Texto) {
        try {
            String[] titulos = {"Ruc", "Telefono", "Nombre/Razon Social", "Direccion", "Correo"};
            String filtro=""+Texto+"%";
            String sql = "select * from PROVEEDOR where Ruc_Provee like"+'"'+filtro+'"';
            model=new DefaultTableModel(null,titulos);
            connn = new Conexion();
            st = connn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[5];
            while (rs.next()) {
                fila[0] = rs.getString("Ruc_Provee");
                fila[1] = rs.getString("Telefono");
                fila[2] = rs.getString("Razon_Social");
                fila[3] = rs.getString("Direccion");
                fila[4] = rs.getString("Correo");
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }
}
