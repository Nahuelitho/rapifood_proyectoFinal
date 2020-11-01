package rapifood.modelo;



import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import rapifood.entidades.*;


public class ProductoData {
    private  Connection con;
    public ProductoData(Conexion c) {
       con= c.getConnection();
    }
    public void guardarProducto(Producto producto){
        String sql="INSERT INTO producto( nombre_producto, precio_producto, estado_producto) VALUES (?,?,?)";
      try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,producto.getNombreProducto());
            ps.setDouble(2, producto.getPrecio());
            ps.setBoolean(3, producto.isEstadoProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
            producto.setIdProducto(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null,"No puedo obtener id");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar producto");
        }
    }
    public  Producto buscarProducto(int id){
        Producto p=null;
        String sql="SELECT * FROM producto WHERE id_producto=?";
         try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            p= new Producto();
            p.setIdProducto(rs.getInt(1));
            p.setNombreProducto(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setEstadoProducto(rs.getBoolean(4));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al encontrar producto");
        }
         return p;
    }
    public List<Producto> obtenerProductos(){
        Producto p;
        List<Producto>productos=new ArrayList<>();
        String sql="SELECT * FROM producto ";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
            p= new Producto();
            p.setIdProducto(rs.getInt(1));
            p.setNombreProducto(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setEstadoProducto(rs.getBoolean(4));
            productos.add(p);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return productos;
    }
    public List<Producto> obtenerProductosDisponibles(){
        Producto p;
        List<Producto>productos=new ArrayList<>();
        String sql="SELECT * FROM producto WHERE estado_producto=1 ";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
            p= new Producto();
            p.setIdProducto(rs.getInt(1));
            p.setNombreProducto(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setEstadoProducto(rs.getBoolean(4));
            productos.add(p);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener productos");
        }
         return productos;
    }
        public void actualizarProducto(Producto producto){
        String sql="UPDATE producto SET nombre_producto =? ,precio_producto =? , estado_producto =? WHERE id_producto=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,producto.getNombreProducto());
            ps.setDouble(2, producto.getPrecio());
            ps.setBoolean(3, producto.isEstadoProducto());
            ps.setInt(4, producto.getIdProducto());
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar producto");
        }
    }
        public void borrarProducto(int id){
            /*
            No se si al borrar solo modifico el booleano de estado para darle de baja
            otra consulta sera si al momento de obtener los productos osea la lista
            deberia ser solo los productos que tengo activos?
            por ahora solamente voy a poner un metodo borrar y otro dar de baja
            */
            String sql="DELETE FROM producto WHERE id_producto=?";
         try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al borrar producto");
            }
        }
        public void DarDeBajaProducto(int id){
        String sql="UPDATE producto SET estado_producto =? WHERE id_producto=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al dar de baja el producto");
        }
    }
        public void DarDeAltaProducto(int id){
        String sql="UPDATE producto SET estado_producto =? WHERE id_producto=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al dar de baja el producto");
        }
    }
}
