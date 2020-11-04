
package rapifood.modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import rapifood.entidades.*;


public class DetallePedidoData {
     private Connection con;

    public DetallePedidoData(Conexion c) {
    con= c.getConnection();
    }
    public void guardarDetallePedido(DetallePedido dp){
        String sql="INSERT INTO detalle_pedido ( id_pedido , id_producto , cantidad_producto , monto_subtotal ) VALUES (?,?,?,?)";
                try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dp.getPedido().getIdPedido());
            ps.setInt(2, dp.getProducto().getIdProducto());
            ps.setInt(3, dp.getCantidad());
            ps.setDouble(4, dp.getMonto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dp.setIdDetalle(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "detalle pedido no guardado");
        }
    }
    public DetallePedido buscarDetalle(int id){
        DetallePedido dp= new DetallePedido();
        String sql="SELECT * FROM detalle_pedido WHERE id_detalle=? ";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
            if(rs.next()){
            dp.setIdDetalle(rs.getInt(1));
            dp.setPedido(buscarPedido(rs.getInt(2)));
            dp.setProducto(buscarProducto(rs.getInt(3)));
            dp.setCantidad(rs.getInt(4));
            dp.setMonto(rs.getDouble(5));
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return dp;
    }    
    public List<DetallePedido> ObtenerDetalles(){
        List<DetallePedido> lista = new ArrayList<>();
        DetallePedido dp;
        String sql="SELECT * FROM detalle_pedido ";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
            dp= new DetallePedido();
            dp.setIdDetalle(rs.getInt(1));
            dp.setPedido(buscarPedido(rs.getInt(2)));
            dp.setProducto(buscarProducto(rs.getInt(3)));
            dp.setCantidad(rs.getInt(4));
            dp.setMonto(rs.getDouble(5));
            lista.add(dp);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return lista;
    }
    public List<DetallePedido> ObtenerDetallesActivo(){
        List<DetallePedido> lista = new ArrayList<>();
        DetallePedido dp;
        String sql="SELECT * FROM detalle_pedido WHERE estado_detalle=1";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
            dp= new DetallePedido();
            dp.setIdDetalle(rs.getInt(1));
            dp.setPedido(buscarPedido(rs.getInt(2)));
            dp.setProducto(buscarProducto(rs.getInt(3)));
            dp.setCantidad(rs.getInt(4));
            dp.setMonto(rs.getDouble(5));
            lista.add(dp);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return lista;
    }
public List<DetallePedido> ObtenerDetallesXPedido(int id){
        List<DetallePedido> lista = new ArrayList<>();
        DetallePedido dp;
        String sql="SELECT * FROM detalle_pedido WHERE id_pedido=?";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
            dp= new DetallePedido();
            dp.setIdDetalle(rs.getInt(1));
            dp.setPedido(buscarPedido(rs.getInt(2)));
            dp.setProducto(buscarProducto(rs.getInt(3)));
            dp.setCantidad(rs.getInt(4));
            dp.setMonto(rs.getDouble(5));
            lista.add(dp);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return lista;
    }    
   public Producto buscarProducto(int id){
       Conexion c=new Conexion();
       ProductoData pd=new ProductoData(c);
       Producto p;
       p=pd.buscarProducto(id);
       return p;
   }  
   public Pedido buscarPedido(int id){
       Conexion c=new Conexion();
       PedidoData pd = new PedidoData(c);
       Pedido p;
       p=pd.buscarPedido(id);
       return p;
   }
    public void borrarDetalle(int id){
            String sql="DELETE FROM detalle_producto WHERE id_detalle=?";
         try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al borrar detalle");
            }
        }
    public void actualizarDetalle(DetallePedido dp){
        String sql="UPDATE detalle_pedido SET cantidad_producto=?, monto_subtotal =? WHERE detalle_pedido.id_detalle=?";
            try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,dp.getCantidad());
            ps.setDouble(2,dp.getMonto());
            ps.setInt(3,dp.getIdDetalle());
            ps.executeUpdate();
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar detalle");
            }
        
    }
}
