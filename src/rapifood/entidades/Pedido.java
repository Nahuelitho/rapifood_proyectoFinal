package rapifood.entidades;

public class Pedido {
    private Mesa mesa;
    private Mesero mesero;
    private int idPedido;
    private double montoTotal;
    private boolean estadoPedido;

    public Pedido(Mesa mesa, Mesero mesero, int idPedido, double montoTotal, boolean estadoPedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.idPedido = idPedido;
        this.montoTotal = montoTotal;
        this.estadoPedido = estadoPedido;
    }       
    
    public Pedido(Mesa mesa, Mesero mesero, double montoTotal, boolean estadoPedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.montoTotal = montoTotal;
        this.estadoPedido = estadoPedido;
    }
    
    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public Pedido() {
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
    
}