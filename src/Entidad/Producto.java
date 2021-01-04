
package Entidad;

import java.sql.Date;

public class Producto {
    private int idPRODUCTO;
    private String Cod_Categoria ;
    private String Cate_Prod;
    private String Cod_Producto;
    private String Descrip_Producto;
    private String Marca;
    private double Cantidad;
    private double Valor_Unitario;
    private String Unidad_Medida;
    private String Fecha_Registro;

    public int getIdPRODUCTO() {
        return idPRODUCTO;
    }

    public void setIdPRODUCTO(int idPRODUCTO) {
        this.idPRODUCTO = idPRODUCTO;
    }

    public String getCod_Categoria() {
        return Cod_Categoria;
    }

    public void setCod_Categoria(String Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }


    public String getCate_Prod() {
        return Cate_Prod;
    }

    public void setCate_Prod(String Cate_Prod) {
        this.Cate_Prod = Cate_Prod;
    }

    public String getCod_Producto() {
        return Cod_Producto;
    }

    public void setCod_Producto(String Cod_Producto) {
        this.Cod_Producto = Cod_Producto;
    }

    public String getDescrip_Producto() {
        return Descrip_Producto;
    }

    public void setDescrip_Producto(String Descrip_Producto) {
        this.Descrip_Producto = Descrip_Producto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getValor_Unitario() {
        return Valor_Unitario;
    }

    public void setValor_Unitario(double Valor_Unitario) {
        this.Valor_Unitario = Valor_Unitario;
    }

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String Unidad_Medida) {
        this.Unidad_Medida = Unidad_Medida;
    }

    public String getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(String Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }


    
}
