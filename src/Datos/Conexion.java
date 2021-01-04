
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection con = null; 
   private String url ="jdbc:mysql://localhost:3306/InventarioFerreteria";
   private String usr ="root";
   private String pss ="Fabiola1903@"; //hola//

    public Conexion() {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection(url, usr, pss);
//           JOptionPane.showMessageDialog(null, "Bienvenido a Ferreteria ''Baratito'");
       } catch (ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en la conexion DBInventarioFerreteria");
       }
    }
    public Connection getConexion(){
    return con;
    }
    public static void main(String[] args) {
        Conexion conn=new Conexion();
        conn.getConexion();
    }
}
