package rapifood.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rapifood.entidades.*;

public class MeseroData {

    private Connection con;

    public MeseroData(Conexion c) {
        con = c.getConnection();
    }

    public void guardarMesero(Mesero mesero) {
        String sql = "INSERT INTO mesero(dni_mesero,cuit_mesero, nombre_mesero, apellido_mesero, estado_mesero)VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesero.getDni());
            ps.setInt(2,mesero.getCuit());
            ps.setString(3, mesero.getNombre());
            ps.setString(4, mesero.getApellido());
            ps.setBoolean(5, mesero.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesero.setIdMesero(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo guardar el mesero");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar mesero");
        }
    }
    
    public Mesero buscarMesero(int id){
    Mesero m =null;
    String sql="SELECT * FROM mesero WHERE id_mesero=?";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            m = new Mesero();
            m.setIdMesero(rs.getInt("id_mesero"));
            m.setCuit(rs.getInt("cuit_mesero"));
            m.setDni(rs.getInt("dni_mesero"));    
            m.setNombre(rs.getString("nombre_mesero"));
            m.setApellido(rs.getString("apellido_mesero"));
            m.setEstado(rs.getBoolean("estado_mesero"));
            JOptionPane.showMessageDialog(null, "Mesero encontrado");
        }
        rs.close();
        ps.close();
    }
    catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error buscar mesero por id");

    }
    return m;
    }
    
    public List<Mesero> obtenerMeseros(){
    Mesero m;
    List<Mesero>meseros=new ArrayList<>();
    String sql = "SELECT * FROM mesero";
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        m=new Mesero();
        m.setIdMesero(rs.getInt(1));
        m.setDni(rs.getInt(2));
        m.setCuit(rs.getInt(3));
        m.setNombre(rs.getString(4));
        m.setApellido(rs.getString(5));
        m.setEstado(rs.getBoolean(6));
        meseros.add(m);}
    }
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error al Obtener Meseros");}
   return meseros;}
    
    public void actualizarMesero(Mesero mesero){
    String sql="UPDATE mesero SET dni_mesero=?,cuit_mesero=?,nombre_mesero=?, apellido_mesero=?, estado_mesero=? ";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, mesero.getDni());
    ps.setInt(2, mesero.getCuit());
    ps.setString(3, mesero.getNombre());
    ps.setString(4, mesero.getApellido());
    ps.setBoolean(5, mesero.isEstado());
    ps.executeUpdate();
     JOptionPane.showMessageDialog(null, "Mesero actualizado con exito");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error al actualizar mesero");}
    }
    
    public void borrarProducto(int id){
    String sql="DELETE FROM mesero WHERE id_mesero=?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null, "Mesero borrado con exito");    
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al borrar Mesero");
    } }
    
    public void DarDeBajaMesero(int id){
        String sql="UPDATE mesero SET estado_mesero =? WHERE id_mesero=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al dar de baja el mesero");
        }
    }
        public void DarDeAltaMesero(int id){
        String sql="UPDATE mesero SET estado_mesero =? WHERE id_mesero=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al dar de baja el mesero");
        }
    }
        
    public List<Mesero> obtenerMeserosActivos(){
    Mesero m;
    List<Mesero>meseros=new ArrayList<>();
    String sql = "SELECT * FROM mesero WHERE estado_mesero=1";
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        m=new Mesero();
        m.setIdMesero(rs.getInt(1));
        m.setDni(rs.getInt(2));
        m.setCuit(rs.getInt(3));
        m.setNombre(rs.getString(4));
        m.setApellido(rs.getString(5));
        m.setEstado(rs.getBoolean(6));
        meseros.add(m);}
    }
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error al obtener meseros activos");}
   return meseros;}

}
