package rapifood.principal;

import java.util.*;
import rapifood.entidades.*;
import rapifood.modelo.*;

public class RapiFood {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        //Producto p = new Producto();
        //ProductoData pd = new ProductoData(c);
        //List<Producto>lprod=new ArrayList<>();
        //pd.DarDeBajaProducto(1);
        //lprod.addAll(pd.obtenerProductosDisponibles());
        //lprod.addAll(pd.obtenerProductos());
        //System.out.println(lprod);
        //pd.guardarProducto(p);
        //p=pd.buscarProducto(1);
        //p.setEstadoProducto(true);
        //p.setPrecio(90);
        //pd.actualizarProducto(p);
        //System.out.println(p);
        //----------------------------prueba MesaData--------------------------//
//       MesaData md = new MesaData(c);
//       Mesa m= new Mesa();
//       m.setCapacidadMaxima(3);
//       m.setEstadoMesa(false);
//       md.guardarMesa(m);
        //md.buscarMesa(2);
        //md.borrarMesa(1);
        //List<Mesa>lismesa=new ArrayList<>();
        //lismesa.addAll(md.obtenerMesasDisponibles());
        //System.out.println(lismesa);
        //lismesa.addAll(md.obtenerMesas());
        //System.out.println(lismesa);
        //md.darBajaMesa(3);
        //md.darAltaMesa(3);

        //-----------Prueba Mesero---------------
        //Mesero m = new Mesero(41272923,151,"Nahuel","vargas",true);
        //MeseroData meserodata = new MeseroData(c);
        //md.guardarMesero(m);
        //m=md.buscarMesero(3);
        //System.out.println(m);
        //List<Mesero>meseros = new ArrayList<>();
        //meseros.addAll(md.obtenerMeseros());
        //System.out.println(meseros);
        //m.setNombre("juan");
        //md.actualizarMesero(m);
        //-----------Prueba pedido------------------
//        MesaData md = new MesaData(c);
//        Mesa mesa= new Mesa();
//        
//        Mesero mesero = new Mesero();
//        MeseroData meserodata = new MeseroData(c);
//        
//        mesa=md.buscarMesa(1);
//        mesero=meserodata.buscarMesero(3);
        //Pedido p = new Pedido();
        PedidoData pd = new PedidoData(c);
        //p=pd.buscarPedido(1);
        //System.out.println(p);
//        pd.guardarPedido(p);
//        List<Pedido>pedidos=new ArrayList<>();
//        pedidos.addAll(pd.obtenerPedidos());
//        System.out.println(pedidos);
          pd.darBajaPedido(2);
        
    }
}
