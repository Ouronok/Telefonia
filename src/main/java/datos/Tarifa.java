package datos;

public class Tarifa {

    private double precio;

    private Tarifa(double precio) {
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
