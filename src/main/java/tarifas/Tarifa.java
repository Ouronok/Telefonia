package tarifas;

import pago.Llamada;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {

    double precio;

    public Tarifa(double precio) {
        this.precio = precio;
    }

   public abstract double getPrecio();

    public double getPrecioLlamada(Llamada llamada){
        return llamada.getDuracion()*precio;
    }


    @Override
    public String toString() {
        return precio + "€";
    }
}
