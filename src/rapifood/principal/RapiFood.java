package rapifood.principal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import rapifood.entidades.*;
import rapifood.modelo.*;

public class RapiFood {

    public static void main(String[] args) {
        Conexion c = new Conexion();
     //   Producto producto = new Producto();
     //   ProductoData pd = new ProductoData(c);
        //List<Producto>lprod=new ArrayList<>();
        //pd.DarDeBajaProducto(1);
        //lprod.addAll(pd.obtenerProductosDisponibles());
        //lprod.addAll(pd.obtenerProductos());
        //System.out.println(lprod);
        //pd.guardarProducto(p);
       // producto=pd.buscarProducto(1);
        //p.setEstadoProducto(true);
        //p.setPrecio(90);
        //pd.actualizarProducto(p);
        //System.out.println(p);
        //----------------------------prueba MesaData--------------------------//
       //MesaData md = new MesaData(c);
       Mesa m= new Mesa();
      //m.setCapacidadMaxima(3);
       //m.setEstadoMesa(true);
       //md.guardarMesa(m);
        //md.buscarMesa(2);
        //md.borrarMesa(1);
        //List<Mesa>lismesa=new ArrayList<>();
        //lismesa.addAll(md.obtenerMesasDisponibles());
        //System.out.println(lismesa);
        //lismesa.addAll(md.obtenerMesas());
        //System.out.println(lismesa);
        //md.darBajaMesa(3)
        //md.darAltaMesa(3);
        //m= md.buscarMesa(5);
        //--------------Prueba ReservaData----------------------
        Reserva r = new Reserva(m,25456516, "joni", "salas", LocalDate.of(2020, 10,30), LocalTime.of(00, 00, 00),true, 3);
        ReservaData rd = new ReservaData(c);
        //List<Reserva> lr = new ArrayList<>();
        //rd.registrarReserva(r);
        //rd.actualizarReserva(r);
        //rd.buscarReservaXFecha("'2020-11-05'");
        System.out.println(rd.buscarReservaXFecha(LocalDate.of(2020, 11,5)));
        //rd.darBajaReserva(2);
        //System.out.println(rd.obtenerReservasXEstado());

        //-----------Prueba Mesero---------------
       // Mesero m = new Mesero(41272923,151,"Nahuel","vargas",true);
       // MeseroData meserodata = new MeseroData(c);
       // meserodata.guardarMesero(m);
        //m=md.buscarMesero(3);
        //System.out.println(m);
        //List<Mesero>meseros = new ArrayList<>();
        //meseros.addAll(md.obtenerMeseros());
        //System.out.println(meseros);
        //m.setNombre("juan");
        //md.actualizarMesero(m);
        //-----------Prueba pedido------------------
       // MesaData md = new MesaData(c);
       // Mesa mesa= new Mesa();       
       // Mesero mesero = new Mesero();
       // MeseroData meserodata = new MeseroData(c);        
       // mesa=md.buscarMesa(1);
       // mesero=meserodata.buscarMesero(1);
        //Pedido p = new Pedido(mesa,mesero,true);
      //  PedidoData pedidodata = new PedidoData(c);
       // pd.guardarPedido(p);
     //   Pedido pedido = new Pedido();
      //  pedido=pedidodata.buscarPedido(1);
        //System.out.println(p);
//        pd.guardarPedido(p);
//        List<Pedido>pedidos=new ArrayList<>();
//        pedidos.addAll(pd.obtenerPedidos());
//        System.out.println(pedidos);
         // pd.darBajaPedido(2);
         
     //-----------Prueba DetallePedido------------------  
     //DetallePedido detallepedido= new DetallePedido();
     //DetallePedidoData dpd=new DetallePedidoData(c);
     //List<DetallePedido> lista = new ArrayList<>();
     //lista.addAll(dpd.ObtenerDetallesXPedido(1));
      //  System.out.println(lista);
    //detallepedido=dpd.buscarDetalle(1);
    //detallepedido.setCantidad(2);
    //dpd.actualizarDetalle(detallepedido);
    }
}
