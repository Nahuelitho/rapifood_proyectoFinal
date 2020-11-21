package rapifood.entidades;


public class Mesero {
    private int idMesero;
    private int dni;
    private int cuit;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Mesero() {
    }

    public Mesero(int dni, int cuit, String nombre, String apellido, boolean estado) {
        this.dni = dni;
        this.cuit = cuit;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Mesero(int idMesero, int dni, int cuit, String nombre, String apellido, boolean estado) {
        this.idMesero = idMesero;
        this.dni = dni;
        this.cuit = cuit;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Mesero(int idMesero) {
        this.idMesero = idMesero;
    }
    
    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getNombre()+" "+ getApellido();
    }
    
    
}
