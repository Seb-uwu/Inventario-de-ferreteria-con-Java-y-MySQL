package Logica;

import Entidad.Producto;
import Datos.ProductoDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProductosL {

    ProductoDB objProductoDB = new ProductoDB();

    public boolean Graba_Producto(Producto producto) {
        return objProductoDB.Graba_Producto(producto);
    }

    public Producto Busca_Producto(String Cod_Producto) {
        return objProductoDB.Busca_Producto(Cod_Producto);
    }

    public boolean Actualiza_Producto(Producto producto) {
        return objProductoDB.Actualiza_Prodcuto(producto);
    }

    public boolean Eliminar_Producto(String Cod_Prodcuto) {
        return objProductoDB.Eliminar_Producto(Cod_Prodcuto);
    }
    public ResultSet fillProducto() throws SQLException{
        return objProductoDB.fillProducto();
    }
    public DefaultTableModel BarraBuscarProducto(String Texto) {
        return objProductoDB.BarraBuscarProducto(Texto);
    }
    
}
