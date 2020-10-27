
package rapifood.entidades;

public class Mesa {
    private int idMesa;
    private boolean estadoMesa;
    private int capacidadMaxima;

    public Mesa(int idMesa, boolean estadoMesa, int capacidadMaxima) {
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Mesa(boolean estadoMesa, int capacidadMaxima) {
        this.estadoMesa = estadoMesa;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
    }
    

    public Mesa() {
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
     public String toString(){
         return "mesa "+idMesa;
     }
}
