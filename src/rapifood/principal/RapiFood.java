package rapifood.principal;

import java.time.*;
import java.util.*;
import rapifood.entidades.*;
import rapifood.modelo.*;

public class RapiFood {

    public static void main(String[] args) {
        Conexion c = new Conexion();
       //Producto producto = new Producto("Gatorade",120,true);
       //ProductoData pd = new ProductoData(c);
        //List<Producto>lprod=new ArrayList<>();
       // pd.DarDeBajaProducto(1);
        //lprod.addAll(pd.obtenerProductosDisponibles());
       // lprod.addAll(pd.obtenerProductos());
       // System.out.println(lprod);
       // pd.guardarProducto(producto);
       // producto=pd.buscarProducto(1);
       // producto.setEstadoProducto(true);
       // producto.setPrecio(90);
       // pd.actualizarProducto(producto);
       // System.out.println(producto);
        //----------------------------prueba MesaData--------------------------//
      //MesaData md = new MesaData(c);
       //Mesa m= new Mesa();
       //Mesa test= new Mesa();
      //m.setCapacidadMaxima(10);
       //m.setEstadoMesa(false);
       //md.guardarMesa(m);
        //test= md.buscarMesa(2);
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
        //Reserva r = new Reserva(test,5000, "juancito", "el capo", LocalDate.of(2020, 11,9), LocalTime.of(12,00,00),true, 6);
        //ReservaData rd = new ReservaData(c); 
        //List<Reserva> lr = new ArrayList<>();
        //rd.registrarReserva(r);
        //r=rd.buscarReserva(5);
        //r.setNombreCliente("Juan");
        //r.setApellidoCliente("Lopez");
        //r.setFechaReserva(LocalDateTime.of(LocalDate.of(2020, 11,19), LocalTime.of(21,30,00)));
        //rd.actualizarReserva(r);
        //rd.buscarReservaXFecha(LocalDate.of(2020, 11,9));
        //System.out.println(rd.buscarReservaXFecha(LocalDate.of(2020, 11,9)));
        //rd.darBajaReserva(5);
        //System.out.println(rd.obtenerReservasXEstado());
        //rd.darAltaReserva(5);

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
        //-----------Prueba mesa------------------
       // MesaData md = new MesaData(c);
       // Mesa mesa= new Mesa();       
       // Mesero mesero = new Mesero();
       // MeseroData meserodata = new MeseroData(c);        
       // mesa=md.buscarMesa(1);
       // mesero=meserodata.buscarMesero(1);
       //-----------Prueba pedido------------------
        //Pedido p = new Pedido(mesa,mesero,true);
     //   PedidoData pedidodata = new PedidoData(c);
        //System.out.println(pedidodata.obtenerTotal(2));
     //  System.out.println(pedidodata.buscarPedidoDeMesaXFecha(LocalDate.of(2020,11,07)));
      //System.out.println(pedidodata.buscarPedidoXMeseroTest(LocalDate.of(2020,11,07)).values()+" "+pedidodata.buscarPedidoXMeseroTest(LocalDate.of(2020,11,07)).keySet());
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
   //  DetallePedido detallepedido= new DetallePedido();
   //  DetallePedidoData dpd=new DetallePedidoData(c);
   //  List<DetallePedido> lista = new ArrayList<>();
   //  lista.addAll(dpd.ObtenerDetallesXPedido(1));
    //  System.out.println(lista);
    //detallepedido=dpd.buscarDetalle(1);
    //detallepedido.setCantidad(2);
    //dpd.actualizarDetalle(detallepedido);
    
    }
}
