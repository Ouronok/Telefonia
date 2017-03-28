package tarifas;

import java.io.Serializable;

public class Tarifa implements Serializable {

    private double precio;

    public Tarifa(double precio) {
        this.precio = precio;
    }

   public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return precio + "€";
    }
}
