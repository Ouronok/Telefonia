package modelo.datos;


import java.io.Serializable;
import java.time.LocalDateTime;


public class Llamada implements Dato, Serializable {

    private String tlf;
    private LocalDateTime fecha;
    private int duracion;

    public Llamada(String tlf, int duracion, LocalDateTime fecha) {
        this.tlf = tlf;
        this.duracion = duracion;
        this.fecha = fecha;
    }
    @Override
    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Telefono llamado: " + tlf + "\n Duracion: " + duracion + "\n Fecha: " + fecha.toString();
    }


}
