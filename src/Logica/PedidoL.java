package Logica;

import Entidad.Pedido;
import Datos.PedidoDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class PedidoL {
    PedidoDB objPedidoDB = new PedidoDB();

    public boolean Graba_Pedido(Pedido pedido) {
        return objPedidoDB.Graba_Pedido(pedido);
    }
    public Pedido Busca_Pedido(String Codigo_Pedido) {
        return objPedidoDB.Busca_Pedido(Codigo_Pedido);
    }
    public boolean Actualiza_Pedido(Pedido pedido) {
        return objPedidoDB.Actualiza_Pedido(pedido);
    }
    public boolean Eliminar_Producto(String Codigo_Pedido) {
        return objPedidoDB.Eliminar_Producto(Codigo_Pedido);
    }
    public ResultSet fillDetalle() throws SQLException{
        return objPedidoDB.fillDetalle();
    }
    public DefaultTableModel BarraBuscarPedido(String Texto) {
        return objPedidoDB.BarraBuscarPedido(Texto);
    }
}
