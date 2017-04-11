package pago;

import datos.Dato;
import tarifas.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Llamada implements Dato, Serializable {

    private String tlf;
    private LocalDateTime fecha;
    private int duracion;
    private double precio;

    public Llamada(String tlf, int duracion, LocalDateTime fecha, Tarifa tarifa) {
        this.tlf = tlf;
        this.duracion = duracion;
        this.fecha = fecha;
        this.precio = tarifa.getPrecio()*duracion;
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

    public double getPrecio(){
        return precio;
    }
}
