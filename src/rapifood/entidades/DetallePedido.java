
package rapifood.entidades;


public class DetallePedido {
    private int idDetalle;
    private Pedido pedido;
    private Producto producto;
    private int cantidad;
    private double monto;

    public DetallePedido() {
    }

    public DetallePedido(int idDetalle, Pedido pedido, Producto producto, int cantidad, double monto) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public DetallePedido(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallePedido(Pedido pedido, Producto producto, int cantidad) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = producto.getPrecio()*cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.monto= producto.getPrecio()*cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetalle=" + idDetalle + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad + ", monto=" + monto + '}';
    }
    
}
