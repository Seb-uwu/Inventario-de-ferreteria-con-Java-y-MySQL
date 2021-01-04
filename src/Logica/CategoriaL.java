package Logica;

import Entidad.Categoria;
import Datos.CategoriaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CategoriaL {
        CategoriaDB objCategoriaDB = new CategoriaDB();
    
    public boolean Graba_categoria(Categoria categoria){
     return objCategoriaDB.Graba_Categoria(categoria);
 }
    public Categoria Busca_Categoria(String Cod_Categoria){
     return objCategoriaDB.Busca_Categoria(Cod_Categoria);   
 }
    public boolean Actualiza_Categoria(Categoria categoria){
     return objCategoriaDB.Actualiza_Categoria(categoria);
 }
    public boolean Eliminar_Categoria(String Cod_Categoria){
     return objCategoriaDB.Eliminar_Categoria(Cod_Categoria);   
 }
    public ResultSet fillCategoria() throws SQLException{
     return objCategoriaDB.fillCategoria();
    }
    public DefaultTableModel BarraBuscarCategoria(String Texto) {
        return objCategoriaDB.BarraBuscarCategoria(Texto);
    }
}
