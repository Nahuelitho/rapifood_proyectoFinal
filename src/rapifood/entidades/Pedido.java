package rapifood.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Pedido {
    private Mesa mesa;
    private Mesero mesero;
    private int idPedido;
    private boolean estadoPedido;
    private LocalDateTime fechaPedido;

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Pedido(Mesa mesa, Mesero mesero, int idPedido, boolean estadoPedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.idPedido = idPedido;
        this.estadoPedido = estadoPedido;
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaPedido=LocalDateTime.of(hoy,ahora);
    }       
    
    public Pedido(Mesa mesa, Mesero mesero, boolean estadoPedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaPedido=LocalDateTime.of(hoy,ahora);
    }
    
    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaPedido=LocalDateTime.of(hoy,ahora);
    }
    
    public Pedido() {
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaPedido=LocalDateTime.of(hoy,ahora);
    }

    public Pedido(Mesero mesero, Mesa mesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public boolean isEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    @Override
    public String toString() {
        
        return "Pedido: " + idPedido  +","+ mesa + "," + mesero  + ", fecha: " + fechaPedido + '}';
    }
    
    
    
}