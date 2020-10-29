
package rapifood.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Reserva {
    private int idReserva;
    private Mesa mesa;
    private int dniCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalDateTime fechaReserva;
    private boolean estadoReserva;
    private LocalDateTime fechaAhora;
    private int cantidadCliente;

    public Reserva(int idReserva, Mesa mesa, int dni, String nombre, String apellido, LocalDate fecha, LocalTime hora, boolean estadoReserva, int cantidadCliente) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.dniCliente = dni;
        this.nombreCliente = nombre;
        this.apellidoCliente = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoReserva = estadoReserva;
        this.fechaReserva= LocalDateTime.of(fecha,hora);
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaAhora=LocalDateTime.of(hoy,ahora);
        this.cantidadCliente=cantidadCliente;
    }

    public Reserva() {
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaAhora=LocalDateTime.of(hoy,ahora);
    }

    public Reserva(Mesa mesa, int dni, String nombre, String apellido, LocalDate fecha, LocalTime hora, boolean estadoReserva, int cantidadCliente) {
        this.mesa = mesa;
        this.dniCliente = dni;
        this.nombreCliente = nombre;
        this.apellidoCliente = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoReserva = estadoReserva;
        this.fechaReserva= LocalDateTime.of(fecha,hora);
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        fechaAhora=LocalDateTime.of(hoy,ahora);
        this.cantidadCliente=cantidadCliente;
    }

    public LocalDateTime getFechaAhora() {
        return fechaAhora;
    }

    public void setFechaAhora(LocalDateTime fechaAhora) {
        this.fechaAhora = fechaAhora;
    }

    public Reserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dni) {
        this.dniCliente = dni;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellido) {
        this.apellidoCliente = apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaHora) {
        this.fechaReserva = fechaHora;
    }

    public boolean isEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getCantidadCliente() {
        return cantidadCliente;
    }

    public void setCantidadCliente(int cantidadCliente) {
        this.cantidadCliente = cantidadCliente;
    }
    
}
