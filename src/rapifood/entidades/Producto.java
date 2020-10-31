
package rapifood.entidades;


public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precio;
    private boolean estadoProducto;

    public Producto(int idProducto, String nombreProducto, double precio, boolean estadoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
    }

    public Producto(String nombreProducto, double precio, boolean estadoProducto) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto() {
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstadoProducto(boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstadoProducto() {
        return estadoProducto;
    }
    
    public String toString(){
        return "Nombre: "+getNombreProducto()+" Precio: "+getPrecio();
    }
}
