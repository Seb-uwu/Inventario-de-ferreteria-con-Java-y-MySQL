package Entidad;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Pedido {

    private String Codigo_Pedido;
    private String Ruc_Provee;
    private String Descrip_Pedido;
    private String Razon_Social;
    private double Precio_Uni;
    private double Cant_Pedido;
    private double Precio_Total;
    private String Fecha_Entrega;

    public String getCodigo_Pedido() {
        return Codigo_Pedido;
    }

    public void setCodigo_Pedido(String Codigo_Pedido) {
        this.Codigo_Pedido = Codigo_Pedido;
    }

    public String getRuc_Provee() {
        return Ruc_Provee;
    }

    public void setRuc_Provee(String Ruc_Provee) {
        this.Ruc_Provee = Ruc_Provee;
    }

    public String getDescrip_Pedido() {
        return Descrip_Pedido;
    }

    public void setDescrip_Pedido(String Descrip_Pedido) {
        this.Descrip_Pedido = Descrip_Pedido;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public double getPrecio_Uni() {
        return Precio_Uni;
    }

    public void setPrecio_Uni(double Precio_Uni) {
        this.Precio_Uni = Precio_Uni;
    }

    public double getCant_Pedido() {
        return Cant_Pedido;
    }

    public void setCant_Pedido(double Cant_Pedido) {
        this.Cant_Pedido = Cant_Pedido;
    }

    public double getPrecio_Total() {
        return Precio_Total;
    }

    public void setPrecio_Total(double Precio_Total) {
        this.Precio_Total = Precio_Total;
    }

    public String getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(String Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }

//    public String TostString() {
//        return this.Razon_Social;
//    }
//
//    public Vector<Pedido> mostrarPedido() {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Conexion conn = new Conexion();
//        Connection con = conn.getConexion();
//
//        Vector<Pedido> datos = new Vector<Pedido>();
//        Pedido dat = null;
//
//        try {
//            String sql = "SELECT * FROM PROVEEDOR";
//            ps = con.prepareCall(sql);
//            rs = ps.executeQuery();
//
//            dat = new Pedido();
//            dat.setRuc_Provee(0);
//            dat.setRazon_Social("Selecciona razon social");
//            datos.add(dat);
//
//            while (rs.next()) {
//                dat = new Pedido();
//                dat.setRuc_Provee(rs.getInt("Ruc_Provee"));
//                dat.setRazon_Social(rs.getString("Razon_Social"));
//                datos.add(dat);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return datos;
//    }

}
