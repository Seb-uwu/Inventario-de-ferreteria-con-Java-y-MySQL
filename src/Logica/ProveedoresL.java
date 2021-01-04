package Logica;

import Entidad.Proveedor;
import Datos.ProveedorDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProveedoresL {

    ProveedorDB objProveedorDB = new ProveedorDB();
    public boolean graba_proveedor(Proveedor proveedor) {
        return objProveedorDB.Graba_Proveedor(proveedor);
    }
    public Proveedor Busca_Proveedor(String Ruc_Provee){
     return objProveedorDB.Busca_Proveedor(Ruc_Provee);   
 }
    public boolean Actualiza_Proveedor(Proveedor proveedor){
     return objProveedorDB.Actualiza_Proveedor(proveedor);
 }
    public boolean Eliminar_Proveedor(String Ruc_Provee){
     return objProveedorDB.Eliminar_Proveedor(Ruc_Provee);   
 }
    public ResultSet fillProveedor() throws SQLException{
        return objProveedorDB.fillProveedor();
    }
    public DefaultTableModel BarraBuscarProveedor(String Texto) {
        return objProveedorDB.BarraBuscarProveedor(Texto);
    }
}
