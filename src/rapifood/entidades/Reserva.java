
package rapifood.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Reserva {
    private int idReserva;
    private Mesa mesa;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalDateTime fechaHora;
    private boolean estadoReserva;

    public Reserva(int idReserva, Mesa mesa, int dni, String nombre, String apellido, LocalDate fecha, LocalTime hora, boolean estadoReserva) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoReserva = estadoReserva;
        this.fechaHora= LocalDateTime.of(fecha,hora);
    }

    public Reserva() {
    }

    public Reserva(Mesa mesa, int dni, String nombre, String apellido, LocalDate fecha, LocalTime hora, boolean estadoReserva) {
        this.mesa = mesa;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoReserva = estadoReserva;
        this.fechaHora= LocalDateTime.of(fecha,hora);
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    
    
}
