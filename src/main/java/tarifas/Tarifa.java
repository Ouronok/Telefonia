package tarifas;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {

    private double precio;

    public Tarifa(double precio) {
        this.precio = precio;
    }

   public double getPrecio() {
        return precio;
    }

    public abstract String descripcion();

    @Override
    public String toString() {
        return precio + "€";
    }
}
