
package rapifood.principal;

import java.util.*;
import rapifood.entidades.*;
import rapifood.modelo.*;


public class RapiFood {
    
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        Producto p = new Producto();
        ProductoData pd = new ProductoData(c);
        List<Producto>lprod=new ArrayList<>();
        //pd.DarDeBajaProducto(1);
        //lprod.addAll(pd.obtenerProductos());
        //System.out.println(lprod);
        //pd.guardarProducto(p);
        p=pd.buscarProducto(1);
        p.setEstadoProducto(true);
        p.setPrecio(90);
        pd.actualizarProducto(p);
        //System.out.println(p);
        
    }
}
