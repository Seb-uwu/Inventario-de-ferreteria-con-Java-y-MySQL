package Datos;

import Entidad.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PedidoDB extends Conexion {

    Pedido objPedido = new Pedido();
    Conexion cn = null;
    Statement pst = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    Conexion connn = null;
    Statement st = null;
    DefaultTableModel model;

    public boolean Graba_Pedido(Pedido pedido) {
        conn = getConexion();
        sql = "Insert into DETALLE_PEDIDO values(?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, pedido.getCodigo_Pedido());
            ps.setString(2, pedido.getRuc_Provee());
            ps.setString(3, pedido.getRazon_Social());
            ps.setString(4, pedido.getDescrip_Pedido());
            ps.setDouble(5, pedido.getPrecio_Uni());
            ps.setDouble(6, pedido.getCant_Pedido());
            ps.setDouble(7, pedido.getPrecio_Total());
            ps.setString(8, pedido.getFecha_Entrega());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de grabación de la TBPedido" + ex);
            return false;
        }
    }

    public Pedido Busca_Pedido(String Codigo_Pedido) {
        conn = getConexion();
        sql = "select * from DETALLE_PEDIDO where Codigo_Pedido=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Codigo_Pedido);
            rs = ps.executeQuery();

            if (rs.next()) {
                objPedido.setCodigo_Pedido(rs.getString("Codigo_Pedido"));
                objPedido.setRazon_Social(rs.getString("Razon_Social"));
                objPedido.setRuc_Provee(rs.getString("Ruc_Provee"));
                objPedido.setDescrip_Pedido(rs.getString("Detalle_Pedido"));
                objPedido.setFecha_Entrega((rs.getString("Fecha_Entrega")));
                objPedido.setPrecio_Uni((rs.getDouble("Precio_Uni")));
                objPedido.setCant_Pedido(rs.getDouble("Cant_Pedido"));
                objPedido.setPrecio_Total(rs.getDouble("Precio_Total"));

                return objPedido;
            } else {
//                JOptionPane.showMessageDialog(null, "No existe el codigo");
                objPedido.setDescrip_Pedido("Nada");
                return objPedido;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de seleccionar de la TBPedido" + ex);
            objPedido.setDescrip_Pedido("Nada");
            return objPedido;
        }
    }

    public boolean Actualiza_Pedido(Pedido pedido) {
        conn = getConexion();
        sql = "update DETALLE_PEDIDO set Ruc_Provee=?,Razon_Social=?,Detalle_Pedido=?,Precio_Uni=?,Cant_Pedido=?,Precio_Total=?,Fecha_Entrega=? where Codigo_Pedido=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(8, pedido.getCodigo_Pedido());
            ps.setString(1, pedido.getRuc_Provee());
            ps.setString(2, pedido.getRazon_Social());
            ps.setString(3, pedido.getDescrip_Pedido());
            ps.setDouble(4, pedido.getPrecio_Uni());
            ps.setDouble(5, pedido.getCant_Pedido());
            ps.setDouble(6, pedido.getPrecio_Total());
            ps.setString(7, pedido.getFecha_Entrega());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de la TBPedido" + ex);
            return false;
        }
    }

    public boolean Eliminar_Producto(String Codigo_Pedido) {
        conn = getConexion();
        sql = "delete from DETALLE_PEDIDO where Codigo_Pedido=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Codigo_Pedido);
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

    public ResultSet fillDetalle() throws SQLException {
        cn = new Conexion();
        pst = cn.getConexion().createStatement();
        rs = pst.executeQuery("SELECT Codigo_Pedido,Razon_Social,Ruc_Provee,Detalle_Pedido,Fecha_Entrega,Precio_Uni,Cant_Pedido,Precio_Total FROM DETALLE_PEDIDO");
        return rs;
    }

    public DefaultTableModel BarraBuscarPedido(String Texto) {
        try {
            String[] titulos = {"Cod.Ped", "Razon Social", "Ruc", "Detalle", "Fecha","Precio.U","Cantidad","Precio.T"};
            String filtro = "" + Texto + "%";
            String sql = "select * from DETALLE_PEDIDO where Codigo_Pedido like" + '"' + filtro + '"';
            model = new DefaultTableModel(null, titulos);
            connn = new Conexion();
            st = connn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("Codigo_Pedido");
                fila[1] = rs.getString("Razon_Social");
                fila[2] = rs.getString("Ruc_Provee");
                fila[3] = rs.getString("Detalle_Pedido");
                fila[4] = rs.getString("Fecha_Entrega");
                fila[5] = rs.getString("Precio_Uni");
                fila[6] = rs.getString("Cant_Pedido");
                fila[7] = rs.getString("Precio_Total");
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }

    public void Combo_box(JComboBox box_pedido) {

        java.sql.Connection conectar = null;
        sql = "SELECT Razon_Social FROM PROVEEDOR";

        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            box_pedido.addItem("Seleccione una opcion");
            while (rs.next()) {
                box_pedido.addItem(rs.getString("Razon_Social"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }

    }
}
