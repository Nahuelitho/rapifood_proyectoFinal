package rapifood.modelo;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;
import rapifood.entidades.*;

public class PedidoData {

    private Connection con;

    public PedidoData(Conexion conexion) {
        con = conexion.getConnection();
    }

    /**
     * **************************************************************************************************************************************************************************************
     */
    public void guardarPedido(Pedido pedi) {
        try {
            String bus = "INSERT INTO pedido(id_mesa, id_mesero, estado_pedido, fecha_pedido) VALUES (?,?,?,?)";
            PreparedStatement prs = con.prepareStatement(bus, Statement.RETURN_GENERATED_KEYS);

            prs.setInt(1, pedi.getMesa().getIdMesa());
            prs.setInt(2, pedi.getMesero().getIdMesero());
            prs.setBoolean(3, pedi.isEstadoPedido());
            prs.setTimestamp(4, Timestamp.valueOf(pedi.getFechaPedido()));
            prs.executeUpdate();
            ResultSet rs = prs.getGeneratedKeys();

            if (rs.next()) {
                pedi.setIdPedido(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "mesa y mesero no guardados");
        }
    }

    /**
     * *************************************************************************************************************************************************************************************
     */
    public List<Pedido> obtenerPedidos() {
        List<Pedido> listapedidos = new ArrayList<>();
        Pedido pedido ;
        String sql = "SELECT * FROM pedido";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                Mesero mesero = new Mesero();
                pedido = new Pedido(mesa, mesero, true);
                pedido.setIdPedido(rs.getInt(1));
                mesa = buscarMesa(rs.getInt(2));
                mesero = buscarMesero(rs.getInt(3));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
                listapedidos.add(pedido);
           //     JOptionPane.showMessageDialog(null, "Pedidos encontrados");
            }
            rs.close();
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo encontrar el pedido");
        }
        return listapedidos;
    }
    public List<Pedido> obtenerPedidosActivos() {
        List<Pedido> listapedidos = new ArrayList<>();
        Pedido pedido ;
        String sql = "SELECT * FROM pedido WHERE estado_pedido=1; ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                Mesero mesero = new Mesero();
                pedido = new Pedido(mesa, mesero, true);
                pedido.setIdPedido(rs.getInt(1));
                mesa = buscarMesa(rs.getInt(2));
                mesero = buscarMesero(rs.getInt(3));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
                listapedidos.add(pedido);
             //   JOptionPane.showMessageDialog(null, "Pedidos encontrados");
            }
            rs.close();
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo encontrar el pedido");
        }
        return listapedidos;
    }

    /*************************************************************************************************************************************************************************************/
    /*************************************************************************************************************************************************************************************/
    public void actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET estado_pedido=? WHERE pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, pedido.isEstadoPedido());
            ps.setInt(2, pedido.getIdPedido());
            ps.executeUpdate();
         //   JOptionPane.showMessageDialog(null, "Pedido actualizado");
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido");
        }
    }

    /**
     * ****************************************************************************************************************************************************************************************
     */
    public void borrarPedido(int id) {
        String sql = "DELETE FROM pedido WHERE  pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
       //     JOptionPane.showMessageDialog(null, "Pedido eliminado");
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la inscripcion");
        }
    }

    /**
     * **************************************************************************************************************************************************************************************
     */
    public Mesero buscarMesero(int id) {
        Conexion c = new Conexion();
        MeseroData meseroData = new MeseroData(c);
        return meseroData.buscarMesero(id);
    }

    public Mesa buscarMesa(int id) {
        Conexion c = new Conexion();
        MesaData mesaData = new MesaData(c);
        return mesaData.buscarMesa(id);
    }

    public Pedido buscarPedido(int id) {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                Mesa mesa = buscarMesa(rs.getInt(2));
                Mesero mesero = buscarMesero(rs.getInt(3));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
            }
            rs.close();
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar");
        }
        return pedido;
    }
    
    public void darBajaPedido(int id){
      String sql="UPDATE pedido SET estado_pedido= ? WHERE id_pedido =?";
      try{
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, false);
          ps.setInt(2, id);
          ps.executeUpdate();
       //   JOptionPane.showMessageDialog(null, "Pedido dado de baja");
          ps.close();
          //con.close();
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Pedido NO dado de baja ", "Error!", JOptionPane.WARNING_MESSAGE);
      } 
  }
  
  public void darAltaPedido(int id){
      String sql="UPDATE pedido SET estado_pedido=? WHERE id_pedido=?";
      try{
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, true);
          ps.setInt(2, id);
          ps.executeUpdate();
     //     JOptionPane.showMessageDialog(null, "Pedido dado de Alta");
          ps.close();
          //con.close();
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Pedido NO dado de Alta ", "Error!", JOptionPane.WARNING_MESSAGE);
      } 
  }
    
    
    


    public List<Pedido> buscarPedidoXMesero(LocalDate fecha) {
        Pedido pedido = null;
        ArrayList<Pedido> pedidoLista = new ArrayList<>();
        String sql = "SELECT p.* FROM pedido p , mesero m WHERE p.id_mesero=m.id_mesero AND DATE(p.fecha_pedido)=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                Mesero mesero=buscarMesero(rs.getInt(2));
                Mesa mesa=buscarMesa(rs.getInt(3));
                pedido.setMesero(mesero);
                pedido.setMesa(mesa);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
                //JOptionPane.showMessageDialog(null, "Pedido encontrado");
                pedidoLista.add(pedido);
            }
            rs.close();
            ps.close();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Pedido no encontrado");
                    }
        return pedidoLista;
        }
    
    public List<Pedido> buscarPedidoDeMesaXFecha(LocalDate fecha){
    String sql = "SELECT p.*  FROM pedido p, detalle_pedido dp, mesa m WHERE dp.id_pedido=p.id_pedido AND p.id_mesa=m.id_mesa and DATE(p.fecha_pedido)=? ";
    Pedido pedido;
    ArrayList<Pedido> pedidoLista = new ArrayList<>();
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, java.sql.Date.valueOf(fecha));
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                Mesero mesero=buscarMesero(rs.getInt(2));
                Mesa mesa=buscarMesa(rs.getInt(3));
                pedido.setMesero(mesero);
                pedido.setMesa(mesa);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
                //JOptionPane.showMessageDialog(null, "Pedido encontrado");
                pedidoLista.add(pedido);
        }
        rs.close();
        ps.close();
    }catch(HeadlessException | SQLException e){
    
    JOptionPane.showMessageDialog(null, "Pedido no encontrado");
    }
    return pedidoLista;
    }
    public List<Double> buscarSubTotalesDeMesaDePedidosXFecha(LocalDate fecha) {
        double numero;
        List<Double> pedidoLista = new ArrayList<>();
        String sql = "SELECT p.id_pedido ,m.id_mesa ,dp.monto_subtotal FROM pedido p, detalle_pedido dp, mesa m WHERE dp.id_pedido=p.id_pedido AND p.id_mesa=m.id_mesa and DATE(p.fecha_pedido)=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               numero=rs.getInt(1);
               pedidoLista.add(numero);
                numero=rs.getInt(2);
               pedidoLista.add(numero);
                numero=rs.getDouble(3);
               pedidoLista.add(numero);
            }
            rs.close();
            ps.close();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Pedido no encontrado");
                    }
        return pedidoLista;
        }
        public double obtenerTotal(int id) {
        double total=0;
        String sql = "SELECT dp.monto_subtotal FROM pedido p, detalle_pedido dp, mesa m WHERE  p.id_pedido=?  AND p.id_mesa=m.id_mesa and dp.id_pedido=p.id_pedido ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total+=rs.getDouble(1);
            }
            rs.close();
            ps.close();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Total no encontrado");
                    }
        return total;
        }
}