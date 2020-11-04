
package rapifood.modelo;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;
import rapifood.entidades.*;

public class ReservaData {
    private Connection con;
   
    public ReservaData(Conexion conexion){
        con=conexion.getConnection();
    }
    
    public void registrarReserva(Reserva reserva){
        int x=0;
        List<Reserva> reservaon = new ArrayList<>();
        reservaon=obtenerReservas();

        String sql="INSERT INTO reserva(id_mesa, dni_cliente, nombre_cliente, apellido_cliente, fecha_reserva, estado_reserva, fecha_ahora, cantidad_cliente)"+
                "VALUES (?,?,?,?,?,?,?,?)";
        try{
            for(int i=0;i<reservaon.size();i++){
                
                Reserva res = reservaon.get(i);
                if(res.getDniCliente()==reserva.getDniCliente()&& res.getFechaReserva().compareTo(reserva.getFechaReserva())==0){
                    x++;
                }
            }
            if(x==0){
                
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setInt(2, reserva.getDniCliente());
            ps.setString(3, reserva.getNombreCliente());
            ps.setString(4, reserva.getApellidoCliente());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(reserva.getFechaReserva()));
            ps.setBoolean(6, reserva.isEstadoReserva());
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(reserva.getFechaAhora()));
            ps.setInt(8, reserva.getCantidadCliente());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                reserva.setIdReserva(rs.getInt(1));
            }else{
                JOptionPane.showMessageDialog(null,"No se pudo obtener id");
            }
            ps.close();
            rs.close();
            //con.close();
            JOptionPane.showMessageDialog(null,"Reserva registrada con exito");
            
            }else{JOptionPane.showMessageDialog(null,"Ya se registro una reserva con ese nombre y en esa fecha");}
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al registrar reserva");
        }
    }
    
    public void actualizarReserva(Reserva reserva){    
        String sql="UPDATE reserva SET id_mesa = ?, dni_cliente = ?, nombre_cliente = ?, apellido_cliente = ?, fecha_reserva = ?,"
                + " estado_reserva =? , fecha_ahora = ?, cantidad_cliente = ? WHERE reserva.id_reserva=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setInt(2, reserva.getDniCliente());
            ps.setString(3, reserva.getNombreCliente());
            ps.setString(4, reserva.getApellidoCliente());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(reserva.getFechaReserva()));
            ps.setBoolean(6, reserva.isEstadoReserva());
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(reserva.getFechaAhora()));
            ps.setInt(8, reserva.getCantidadCliente());
            ps.setInt(9, reserva.getIdReserva());
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Actualizacion realizada con exito");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar Reserva");
        }
        
    }
    
    public Reserva buscarReserva(int id){
        Reserva reserva=null;
        String sql="SELECT * FROM reserva WHERE reserva.id_reserva=?";
        
        try{
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                reserva= new Reserva();
                reserva.setIdReserva(rs.getInt(1));
                Mesa m=buscarMesa(rs.getInt(2));
                reserva.setMesa(m);
                reserva.setDniCliente(rs.getInt(3));
                reserva.setNombreCliente(rs.getString(4));
                reserva.setApellidoCliente(rs.getString(5));
                reserva.setFechaReserva(rs.getTimestamp(6).toLocalDateTime());
                reserva.setEstadoReserva(rs.getBoolean(7));
                reserva.setFechaAhora(rs.getTimestamp(8).toLocalDateTime());
                reserva.setCantidadCliente(rs.getInt(9));
                JOptionPane.showMessageDialog(null, "Reserva encontrada");
            }
            rs.close();
            ps.close();
            //con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar Reserva");
        }
        return reserva;
    }
     public Mesa buscarMesa(int id){
            Conexion c =new Conexion();
            MesaData ad = new MesaData(c);
            return ad.buscarMesa(id);      
    }
    
     public List<Reserva> obtenerReservas(){
         List<Reserva> reservas = new ArrayList<>();
         Reserva reserv;
         
         String sql="SELECT * FROM reserva";
         try{
             PreparedStatement ps= con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 reserv = new Reserva();
                 reserv.setIdReserva(rs.getInt(1));
                 Mesa m =buscarMesa(rs.getInt(2));      
                 reserv.setMesa(m);
                 reserv.getMesa().setIdMesa(rs.getInt(2));
                 reserv.setDniCliente(rs.getInt(3));
                 reserv.setNombreCliente(rs.getString(4));
                 reserv.setApellidoCliente(rs.getString(5));
                 reserv.setFechaReserva(rs.getTimestamp(6).toLocalDateTime());
                 reserv.setEstadoReserva(rs.getBoolean(7));
                 reserv.setFechaAhora(rs.getTimestamp(8).toLocalDateTime());
                 reserv.setCantidadCliente(rs.getInt(9));
                 reservas.add(reserv); 
             }
             ps.close();
             rs.close();
             //con.close();
         }catch(SQLException e){
             
             JOptionPane.showMessageDialog(null,"Error al Listar reservas");
         }
      return reservas;  
     }
     
     public void borrarReserva(int id){
         String sql="DELETE FROM reserva WHERE reserva.id_reserva=?";
         try{
             PreparedStatement ps =con.prepareStatement(sql);
             ps.setInt(1, id);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Reserva Eliminada");  
             
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, "No se pudo eliminar reserva", "Error", JOptionPane.WARNING_MESSAGE);
         }
    
    }
     
    public void darBajaReserva(int id){
        String sql="UPDATE reserva SET estado_reserva= ? WHERE id_reserva =?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva dada de baja");
            ps.close();
            //con.close();
            
        }catch(SQLException e){        
             JOptionPane.showMessageDialog(null,"Error al dar de baja la reserva");
         }
    }
    
    public void darAltaReserva(int id){
        String sql="UPDATE reserva SET estado_reserva= ? WHERE id_reserva =?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva dada de alta");
            ps.close();
            //con.close();
            
        }catch(SQLException e){        
             JOptionPane.showMessageDialog(null,"Error al dar de alta la reserva");
         }
    }
    
    public List<Reserva> buscarReservaXFecha(LocalDate fecha){
       List<Reserva> reservas = new ArrayList<>();
       Reserva res=null;   
       String sql="SELECT * FROM reserva WHERE date(fecha_reserva)=?";
       
       //String fechastr = fecha.toString();
       try{
           PreparedStatement ps = con.prepareStatement(sql);
           //ps.setString(1, fechastr);
           ps.setDate(1, java.sql.Date.valueOf(fecha));
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               res = new Reserva();
               res.setIdReserva(rs.getInt(1));
               Mesa m =buscarMesa(rs.getInt(2));      
               res.setMesa(m);
               res.setDniCliente(rs.getInt(3));
               res.setNombreCliente(rs.getString(4));
               res.setApellidoCliente(rs.getString(5));
               res.setFechaReserva(rs.getTimestamp(6).toLocalDateTime());
               res.setEstadoReserva(rs.getBoolean(7));
               res.setFechaAhora(rs.getTimestamp(8).toLocalDateTime());
               res.setCantidadCliente(rs.getInt(9));
               reservas.add(res); 
           }
           rs.close();
           ps.close();
           //con.close();
       }catch(SQLException e){        
             JOptionPane.showMessageDialog(null,"Error al buscar reserva x fecha");
       }
      return reservas;  
    }
    
    public List<Reserva> obtenerReservasXEstado(){
         List<Reserva> reservas = new ArrayList<>();
         Reserva reserv;
         
         String sql="SELECT * FROM reserva WHERE estado_reserva = 1";
         try{
             PreparedStatement ps= con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 reserv = new Reserva();
                 reserv.setIdReserva(rs.getInt(1));
                 Mesa m =buscarMesa(rs.getInt(2));      
                 reserv.setMesa(m);
                 reserv.getMesa().setIdMesa(rs.getInt(2));
                 reserv.setDniCliente(rs.getInt(3));
                 reserv.setNombreCliente(rs.getString(4));
                 reserv.setApellidoCliente(rs.getString(5));
                 reserv.setFechaReserva(rs.getTimestamp(6).toLocalDateTime());
                 reserv.setEstadoReserva(rs.getBoolean(7));
                 reserv.setFechaAhora(rs.getTimestamp(8).toLocalDateTime());
                 reserv.setCantidadCliente(rs.getInt(9));
                 reservas.add(reserv); 
             }
             ps.close();
             rs.close();
             //con.close();
         }catch(SQLException e){
             
             JOptionPane.showMessageDialog(null,"Error al Listar reservas por estado");
         }
      return reservas;  
     }
}
