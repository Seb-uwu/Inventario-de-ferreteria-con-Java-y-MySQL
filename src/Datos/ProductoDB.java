package Datos;

//import Entidad.Usuario;
import Entidad.Producto;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoDB extends Conexion {

    Producto objProducto = new Producto();
    Conexion cn = null;
    Statement pst = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    Conexion connn = null;
    Statement st = null;
    DefaultTableModel model;

    public boolean Graba_Producto(Producto producto) {
        conn = getConexion();
        sql = "Insert into PRODUCTO values(null,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, producto.getCod_Producto());
            ps.setString(2, producto.getCate_Prod());
            ps.setString(3, producto.getCod_Categoria());
            ps.setString(4, producto.getDescrip_Producto());
            ps.setString(5, producto.getMarca());
            ps.setDouble(6, producto.getCantidad());
            ps.setDouble(7, producto.getValor_Unitario());
            ps.setString(8, producto.getUnidad_Medida());
            ps.setString(9, producto.getFecha_Registro());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de grabación de la TBProducto" + ex);
            return false;
        }
    }

    public Producto Busca_Producto(String Cod_Producto) {
        conn = getConexion();
        sql = "select * from PRODUCTO where Cod_Producto=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Cod_Producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                objProducto.setCod_Categoria(rs.getString("Cod_Categoria"));
                objProducto.setCod_Producto(rs.getString("Cod_Producto"));
                objProducto.setDescrip_Producto(rs.getString("Descrip_Producto"));
                objProducto.setMarca(rs.getString("Marca"));
                objProducto.setCantidad((rs.getDouble("Cantidad")));
                objProducto.setValor_Unitario((rs.getDouble("Valor_Unitario")));
                objProducto.setUnidad_Medida(rs.getString("Unidad_Medida"));
                objProducto.setFecha_Registro(rs.getString("Fecha_Registro"));

                return objProducto;
            } else {
//                JOptionPane.showMessageDialog(null, "No existe el codigo");
                objProducto.setDescrip_Producto("Nada");
                return objProducto;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de seleccionar de la TBProveedor" + ex);
            objProducto.setDescrip_Producto("Nada");
            return objProducto;
        }
    }

    public boolean Actualiza_Prodcuto(Producto producto) {
        conn = getConexion();
        sql = "update PRODUCTO set Cod_Categoria=?,Descrip_Producto=?,Marca=?,Cate_Prod=?,Cantidad=?,Valor_Unitario=?,Unidad_Medida=?,Fecha_Registro=? where Cod_Producto=?";
        try {
            ps = conn.prepareStatement(sql);
            
            ps.setString(9, producto.getCod_Producto());
            ps.setString(1, producto.getCod_Categoria());
            ps.setString(2, producto.getDescrip_Producto());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getCate_Prod());
            ps.setDouble(5, producto.getCantidad());
            ps.setDouble(6, producto.getValor_Unitario());
            ps.setString(7, producto.getUnidad_Medida());
            ps.setString(8, producto.getFecha_Registro());
            
           

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de la TBProducto" + ex);
            return false;
        }
    }

    public boolean Eliminar_Producto(String Cod_Producto) {
        conn = getConexion();
        sql = "delete from PRODUCTO where Cod_Producto=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Cod_Producto);
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

    public ResultSet fillProducto() throws SQLException {
        cn = new Conexion();
        pst = cn.getConexion().createStatement();
        rs = pst.executeQuery("SELECT Cod_Producto,Cate_Prod,Cod_Categoria,Descrip_Producto,Marca,Cantidad,Valor_Unitario,Unidad_Medida,Fecha_Registro FROM PRODUCTO");
        return rs;
    }

    public DefaultTableModel BarraBuscarProducto(String Texto) {
        try {
            String[] titulos = {"Cod.Prod", "Cat.Prod", "Cod.Cat", "Descrip", "Marca", "Cant", "Valor.U", "Uni.Med", "Fecha.Reg"};
            String filtro = "" + Texto + "%";
            String sql = "select * from PRODUCTO where Cod_Producto like" + '"' + filtro + '"';
            model = new DefaultTableModel(null, titulos);
            connn = new Conexion();
            st = connn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[9];
            while (rs.next()) {
                fila[0] = rs.getString("Cod_Producto");
                fila[1] = rs.getString("Cate_Prod");
                fila[2] = rs.getString("Cod_Categoria");
                fila[3] = rs.getString("Descrip_Producto");
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Cantidad");
                fila[6] = rs.getString("Valor_Unitario");
                fila[7] = rs.getString("Unidad_Medida");
                fila[8] = rs.getString("Fecha_Registro");
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }

    public void Combo_box(JComboBox box_PRODUCTO) {

        sql = "SELECT Categoria FROM CATEGORIA";

        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            box_PRODUCTO.addItem("Seleccione una opcion");
            while (rs.next()) {
                box_PRODUCTO.addItem(rs.getString("Categoria"));
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
